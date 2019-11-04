import React, { Component } from 'react';
import { StyleSheet, Text, View, Image, Dimensions, TouchableNativeFeedback ,NativeModules} from 'react-native';
const device = Dimensions.get('window')
const width = device.width
export default class Login extends Component {

    constructor(props) {
        super(props)
        this.state = {
            username: '',
            password: '',
            ways: ['./img/weixin.png', './img/qq.png', './img/sina.png'],
            isAgree: false
        }
    }

    agree = () => { this.setState({ isAgree: !this.state.isAgree }) }

    callBack=(name,gender,icon)=>{alert(name)}

    wxLogin=()=>{NativeModules.Login.wxLogin(this.callBack)}

    qqLogin=()=>{NativeModules.Login.qqLogin(this.callBack)}

    sinaLogin=()=>{NativeModules.Login.sinaLogin(this.callBack)}

    login=()=>{ alert('直接进首页')}
    
    register=()=>{  alert('跳到注册页') }

    render(){
        let { ways } = this.state
        return (
            <View style={styles.loginAll}>

                <Text style={styles.head} onPress={this.register}>注册</Text>

                <View style={styles.logo_c}>
                    <Image source={require('./img/music.png')}></Image>
                </View>
                <View style={styles.bt_c}>
                    <TouchableNativeFeedback onPress={this.login}>
                        <View style={styles.bt}>
                            <Text style={styles.bt_text}>手机号登录</Text>
                        </View>
                    </TouchableNativeFeedback>
                </View>
                <View style={styles.ways}>
                    <View style={styles.way_c} onTouchEnd={this.wxLogin}>
                        <Image style={styles.way} source={require('./img/weixin.png')}></Image>
                    </View>
                    <View style={styles.way_c} onTouchEnd={this.qqLogin}>
                        <Image style={styles.way} source={require('./img/qq.png')}></Image>
                    </View>
                    <View style={styles.way_c} onTouchEnd={this.sinaLogin}>
                        <Image style={styles.way} source={require('./img/sina.png')}></Image>
                    </View>
                </View>
                <View style={styles.argument}>
                    <View style={styles.gou_k} onTouchEnd={this.agree}>
                        <Text style={styles.gou}>{this.state.isAgree ? '√' : ''}</Text>
                    </View>
                    <Text style={styles.text_a}>  同意
                        <Text style={styles.text_b}>《用户协议》</Text>
                        和
                        <Text style={styles.text_b}>《私权政策》</Text>
                    </Text>
                </View>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    loginAll: {
        flex: 1,
        backgroundColor: '#ee0011'
    },
    head: {
        textAlign: 'right',
        fontSize: 16,
        color: '#fff',
        margin: 10
    },
    logo_c: {
        flex: 8,
        justifyContent: 'center',
        alignItems: 'center'
    },
    bt_c: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center'
    },
    bt: {
        width: width - 120,
        height: 40,
        backgroundColor: '#fff',
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: 20
    },
    bt_text: {
        fontSize: 16,
        color: '#e62310'
    },
    ways: {
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'space-around',
        alignItems: 'center',
        marginLeft: 30,
        marginRight: 30
    },
    way_c: {
        height: 30,
        width: 30,
        borderRadius: 15,
        borderWidth: 0.5,
        borderColor: '#fff',
        justifyContent: 'center',
        alignItems: 'center',
    },
    way: {
        height: 25,
        width: 25
    },
    argument: {
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center'
    },
    gou_k: {
        height: 18,
        width: 18,
        borderRadius: 2,
        borderWidth: 2,
        borderColor: '#fff',
        justifyContent: 'center',
        alignItems: 'center'
    },
    gou: {
        color: '#fff',
        fontSize: 15
    },
    text_a: {
        fontSize: 12,
        color: '#bbb'
    },
    text_b: {
        fontSize: 15,
        color: '#fff'
    }
})