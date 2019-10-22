import React, { Fragment } from 'react';
import Login from './pages/login/MusicLogin'
import { createStore,applyMiddleware } from 'redux'
import { Provider} from 'react-redux'
import {reducers} from './reducer/reducers'
// import {loginReducer} from './reducer/loginReducer'
import thunk from 'redux-thunk'

const store = createStore(reducers,applyMiddleware(thunk))

const App = () => {
    return (<Provider store={store}>
        <Login></Login>
    </Provider>)
}

export default App;