import * as actionTypes from './actionType';

const initialState = {
    products: [],
    product: null,
    loading: false,
    error: null
};

const productReducer = (state = initialState, action) => {
    switch (action.type) {
        case actionTypes.FIND_PRODUCT_BY_CATEGORY_REQUEST:
        case actionTypes.FIND_PRODUCT_BY_ID_REQUEST:
            return {...state,loading:true,error : null}
        case actionTypes.FIND_PRODUCT_BY_CATEGORY_SUCCESS:
            return {...state, products: action.payload, loading: false, error: null};
        case actionTypes.FIND_PRODUCT_BY_ID_SUCCESS:
            return {...state, product: action.payload, loading: false, error: null};
        case actionTypes.FIND_PRODUCT_BY_CATEGORY_FAILURE:
        case actionTypes.FIND_PRODUCT_BY_ID_FAILURE:
            return {...state, loading: false, error: action.payload};
        default:
            return state;
    }
};

export default productReducer;