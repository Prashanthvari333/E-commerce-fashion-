import * as actionTypes from './actionTypes';
import api from '../../config/apiConfig';
export const getCart = () => async(dispatch) => {
    dispatch({ type: actionTypes.GET_CART_REQUEST });

    try {
        const { data } = await api.get('/api/cart');
        dispatch({ type: actionTypes.GET_CART_SUCCESS, payload: data });
    } catch (error) {
        dispatch({ type: actionTypes.GET_CART_FAILURE, payload: error.message });
    }
};
export const addItemToCart = (item) => async(dispatch) => {
    dispatch({ type: actionTypes.ADD_ITEM_TO_CART_REQUEST });

    try {
        const { data } = await api.post('/api/cart/add', item.data);
        dispatch({ type: actionTypes.ADD_ITEM_TO_CART_SUCCESS, payload: data });
    } catch (error) {
        dispatch({ type: actionTypes.ADD_ITEM_TO_CART_FAILURE, payload: error.message });
    }
};


export const removeCartItem = (itemId) => async(dispatch) => {
    dispatch({ type: actionTypes.REMOVE_CART_ITEM_REQUEST });

    try {
        const { data } = await api.delete(`/api/cart_items/${itemId}`);
        dispatch({ type: actionTypes.REMOVE_CART_ITEM_SUCCESS, payload: data });
    } catch (error) {
        dispatch({ type: actionTypes.REMOVE_CART_ITEM_FAILURE, payload: error.message });
    }
};

export const updateCartItem = (updateData) => async(dispatch) => {
    dispatch({ type: actionTypes.UPDATE_CART_ITEM_REQUEST });

    try {
        const { data } = await api.put(`/api/cart/update/${updateData.cartItemId}`, updateData.data);
        dispatch({ type: actionTypes.UPDATE_CART_ITEM_SUCCESS, payload: data });
    } catch (error) {
        dispatch({ type: actionTypes.UPDATE_CART_ITEM_FAILURE, payload: error.message });
    }
};