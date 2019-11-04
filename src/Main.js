import React from 'react';
import Login from './pages/login/LoginRedux'
import { createStore, applyMiddleware } from 'redux'
import { Provider } from 'react-redux'
import reducers from './reducers/allReducers'
// import {loginReducer} from './reducer/loginReducer'
import thunk from 'redux-thunk'

const store = createStore(reducers, applyMiddleware(thunk))
// const createStoreWithMiddleware = applyMiddleware(thunk, promiseMiddleware)(createStore);
// const store = createStoreWithMiddleware(rootReducer);

const App = () => {
    return (
        <Provider store={store}>
            <Login/>
        </Provider>
    )
}

export default App;