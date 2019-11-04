import React, { Component } from 'react';
import { StyleSheet, View, Button, Dimensions, Image } from 'react-native';
import Gallery from './PFGalleryManager'
import CameraRoll from '@react-native-community/cameraroll'
const device = Dimensions.get('window')
const width = device.width
// //照片获取参数
// var fetchParams = {
//     first: 6,
//     groupTypes: 'All',
//     assetType: 'Photos'
// }
export default class TestGallery extends Component {

    constructor(props) {
        super(props)
        this.state = {
            imgPath: require('../login/img/music.png')
        }
    }

    // //页面的组件渲染完毕（render）之后执行
    // componentDidMount() {
    //     //获取照片
    //     var promise = CameraRoll.getPhotos(fetchParams)
    //     promise.then(
    //         (data) => {
    //             var edges = data.edges;
    //             var photos = [];
    //             for (var i in edges) {
    //                 photos.push(edges[i].node.image.uri);
    //                 console.log(photos[i])
    //             }
    //             this.setState({
    //                 photos: photos
    //             });
    //         },
    //         (err) => {
    //             alert('获取照片失败！');
    //         });
    // }

    openGallery = () => {
        Gallery.getImage(150,200,(path) => {
                //console.log(path)
                this.setState({
                    imgPath: { uri: path }
                })
            }
        )
    }

    render() {
        let { imgPath } = this.state
        return (
            <View style={{ flex: 1 }}>
                <Button title='本地图库' onPress={this.openGallery}></Button>
                <View style={styles.imgContainer} >
                    <Image style={{ width: 150, height: 200 }} source={imgPath} />
                </View>
            </View>
        )
    }

}

const styles = StyleSheet.create({
    imgContainer: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
})