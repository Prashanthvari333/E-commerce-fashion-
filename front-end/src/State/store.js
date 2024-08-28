import { applyMiddleware, combineReducers, legacy_createStore } from 'redux';
import { thunk } from 'redux-thunk';
import { authReducer } from './Auth/Reducer';
import cartReducer from './Cart/reducer';
import productReducer from './Product/reducer';

const rootReducers = combineReducers({
    auth: authReducer,
    product: productReducer,
    cart: cartReducer,
})

export const store = legacy_createStore(rootReducers, applyMiddleware(thunk))