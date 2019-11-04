package com.rn_learn.component.localgallery;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;

import com.facebook.react.bridge.Callback;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;

import static android.app.Activity.RESULT_OK;

public class Gallery {

    private static Gallery instance=null;
    private WeakReference<Activity> mActivity;
    private Callback callback=null;
    private int expectedHeight =0, expectedWidth =0;

    private Gallery(Activity activity){
        mActivity = new WeakReference<Activity>(activity);
    }

    public static void createInstance(Activity activity){
        if(instance==null){
            instance = new Gallery(activity);
        }
    }

    public static Gallery getInstance(){
        if(instance==null){
            Log.e("Gallery___", "not init Gallery instance");
        }
        return instance;
    }

    public void openGallery(int width,int height,Callback callback){
        this.expectedWidth =width;
        this.expectedHeight =height;
        this.callback = callback;
        openGallery();
    }

    private void openGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        mActivity.get().startActivityForResult(intent, 100);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode == RESULT_OK && requestCode == 100) {
            if (data != null) {
                Uri dataPhoto = data.getData();

                //base64编码开始时间
                long startTime=System.currentTimeMillis();

                //对选择的图片进行base64编码
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeStream(mActivity.get().getContentResolver().openInputStream(dataPhoto));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                int scala = calScala(bitmap);
                bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth()/scala, bitmap.getHeight()/scala, true);

                //String realPath = getImagePath(dataPhoto, null);
                String strImg=null;
                try {
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    byte[] bytes = outputStream.toByteArray();
                    strImg = Base64.encodeToString(bytes, Base64.DEFAULT);
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                //base64编码开始时间
                startTime=System.currentTimeMillis()-startTime;
                Log.i("base64编码耗时",""+startTime);

                callback.invoke("data:image/png;base64,"+strImg);
            }
        }
    }

    private int calScala(Bitmap image){
        int scala=1;
        int realWidth=image.getWidth();
        int realHeight=image.getHeight();
        if (realWidth > expectedWidth || realHeight > expectedHeight) {
            realWidth=realWidth/2;
            realHeight = realHeight / 2;
            while (realWidth / scala > expectedWidth || realHeight / scala > expectedHeight) {
                scala*=2;
            }
        }
        return scala/2;
    }

    private String getImagePath(Uri uri, String selection){
        String path =null;
        //通过Uri和selection来获取真实的图片路径
        Cursor cursor = mActivity.get().getContentResolver().query(uri, null, selection, null, null);

        if(cursor !=null) {
            if(cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
}
        return path;
}

}
