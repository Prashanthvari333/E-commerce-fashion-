import * as actionTypes from './actionType';

const initialState = {
    cart: null,
    loading: false,
    error: null,
    cartItems: [],
};

const cartReducer = (state = initialState, action) => {
    switch (action.type) {
        case actionTypes.GET_CART_REQUEST:
        case actionTypes.ADD_ITEM_TO_CART_REQUEST:
        case actionTypes.REMOVE_CART_ITEM_REQUEST:
        case actionTypes.UPDATE_CART_ITEM_REQUEST:
            return {
                ...state,
                loading: true,
                error: null,
            };

        case actionTypes.GET_CART_SUCCESS:
            return {
                ...state,
                loading: false,
                cart: action.payload,
                cartItems: action.payload.items || [], // Assuming the cart object has an `items` array
                error: null,
            };

        case actionTypes.ADD_ITEM_TO_CART_SUCCESS:
            return {
                ...state,
                loading: false,
                cart: action.payload,
                cartItems: action.payload.items || [], // Update the cart items with the new data
                error: null,
            };

        case actionTypes.REMOVE_CART_ITEM_SUCCESS:
            return {
                ...state,
                loading: false,
                cart: action.payload,
                cartItems: action.payload.items || [], // Update the cart items with the new data
                error: null,
            };

        case actionTypes.UPDATE_CART_ITEM_SUCCESS:
            return {
                ...state,
                loading: false,
                cart: action.payload,
                cartItems: action.payload.items || [], // Update the cart items with the new data
                error: null,
            };

        case actionTypes.GET_CART_FAILURE:
        case actionTypes.ADD_ITEM_TO_CART_FAILURE:
        case actionTypes.REMOVE_CART_ITEM_FAILURE:
        case actionTypes.UPDATE_CART_ITEM_FAILURE:
            return {
                ...state,
                loading: false,
                error: action.payload,
            };

        default:
            return state;
    }
};

export default cartReducer;