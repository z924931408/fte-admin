import {applyMiddleware, combineReducers, compose, createStore} from 'redux';
import menuReducer from './../reducer';
import userReducer from '../../pages/user/redux/reducer'
import roleReducer from '../../pages/role/redux/reducer'
import thunk from "redux-thunk";

const reducers = combineReducers({
    menuReducer,
    userReducer,
    roleReducer
})

const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;

const enhancer = composeEnhancers(
    applyMiddleware(thunk),
);
const store = createStore(reducers, enhancer);

export default store;


