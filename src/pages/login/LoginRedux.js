import React, { Component } from 'react';
import { StyleSheet, Text, View, TextInput, Image, Button } from 'react-native';

import { connect } from 'react-redux'
import { setPasswordAction, setUsernameAction, loginAction } from '../../actions/loginAction'

//@connect(mapStateToProps, mapDispatchToProps)
class AppLogin extends Component {

  constructor(props) {
    super(props)
    this.state = {
      username: '',
      password: ''
    }
  }
 

  changePage() {
    this.props.navigation.navigate('GesturePd')
  }

  login=()=>{}

  render() {
    //alert(connect)
      let {username,password} =this.state
    return (

      <View style={styles.loginAll}>

        <View style={styles.body}>
          <TextInput placeholder='账号' onChangeText={(text) => this.props.setUsername(text)}></TextInput>
          <TextInput placeholder='密码' onChangeText={(text) => this.props.setPassword(text)}></TextInput>
          <Button style={styles.button} title='登录' onPress={()=>this.props.login(username,password)} />
        </View>

        <View style={{ height: 60 }}></View>

        <Text style={styles.other}>登录即代表您已经同意
          <Text style={styles.treaty}>《用户服务协议》</Text>
          和
          <Text style={styles.treaty}>《隐私权政策》</Text></Text>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  loginAll: {
    flex: 1,
    justifyContent: 'space-between'
  },
  body: {
    marginLeft: 20,
    marginRight: 20,
    marginTop:150,
    height: 300
  },
  button: {
    borderRadius: 20,
    backgroundColor: '#e11'
  },
  bodyTips: {
    flexDirection: 'row',
    justifyContent: "space-between",
    marginTop: 15
  },
  tipShort: {
    fontSize: 18
  },
  treaty: {
    color: '#e11',
    fontSize: 14
  },
  other: {
    fontSize: 15,
    color: '#aaa',
    justifyContent: 'center',
    marginLeft: 20,
    marginRight: 20
  }
})

// Map Redux state to component props
function mapStateToProps(state) {
  return {
    password: state.login.password,
    username: state.login.username,
    status: state.login.status
  }
}

// Map Redux actions to component props
function mapDispatchToProps(dispatch) {
  //alert(dispatch)
  return {
    login: (username, password) => dispatch(loginAction(username, password)),
    setPassword: (value) => dispatch(Object.assign({}, setPasswordAction, { password: value })),
    setUsername: (value) => dispatch(Object.assign({}, setUsernameAction, { username: value }))
    //setUsername:()=>dispatch(action) //其中action是{ type: 'INCREMENT' }
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(AppLogin);
