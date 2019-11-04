package com.rn_learn.component;

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

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Date;

import static android.app.Activity.RESULT_OK;

public class Gallery {

    private static Gallery instance=null;
    private WeakReference<Activity> mActivity;
    private Callback callback=null;
    private int height=0,width=0;

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
        this.width=width;
        this.height=height;
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
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeStream(mActivity.get().getContentResolver().openInputStream(dataPhoto));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                bitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth()/4, bitmap.getHeight()/4, true);

                //String realPath = getImagePath(dataPhoto, null);

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                byte[] bytes = outputStream.toByteArray();
                String strImg = Base64.encodeToString(bytes, Base64.DEFAULT);

                callback.invoke("data:image/png;base64,"+strImg);
            }
        }
    }

    private int calScala(int realWidth,int realHeight){
        int scala=1;
        return scala;
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
