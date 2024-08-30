import axios from 'axios';
import {
    FIND_PRODUCT_BY_CATEGORY_FAILURE,
    FIND_PRODUCT_BY_CATEGORY_SUCCESS,
    FIND_PRODUCT_BY_ID_SUCCESS,
    FIND_PRODUCT_BY_ID_FAILURE,
    FETCH_PRODUCTS_REQUEST,
    FETCH_PRODUCTS_SUCCESS,
    FETCH_PRODUCTS_FAILURE,
    ADD_PRODUCT_SUCCES,
    ADD_PRODUCT_REQUEST,
    FIND_PRODUCT_BY_ID_REQUEST,
    FIND_PRODUCT_BY_CATEGORY_REQUEST,
    ADD_PRODUCT_SUCCESS,
    ADD_PRODUCT_FAILURE
} from './actionType';
import { api, API_BASE_URL } from '../../config/apiConfig';



export const fetchProducts = () => {
    return (dispatch) => {
        dispatch({ type: FETCH_PRODUCTS_REQUEST });

        axios.get(`${API_BASE_URL}/api/products`)
            .then(response => {
                dispatch({
                    type: FETCH_PRODUCTS_SUCCESS,
                    payload: response.data
                });
            })
            .catch(error => {
                dispatch({
                    type: FETCH_PRODUCTS_FAILURE,
                    payload: error.message
                });
            });
    };
};

export const addProduct = (productData) => {
    return (dispatch) => {
        dispatch({ type: ADD_PRODUCT_REQUEST });

        axios.post(`${API_BASE_URL}/api/products`, productData)
            .then(response => {
                dispatch({
                    type: ADD_PRODUCT_SUCCESS,
                    payload: response.data
                });
            })
            .catch(error => {
                dispatch({
                    type: ADD_PRODUCT_FAILURE,
                    payload: error.message
                });
            });
    };
};
export const findProductById = (productId) => async(dispatch) => {
    dispatch({ type: FIND_PRODUCT_BY_ID_REQUEST });


    const { productId } = productId;

    try {
        const { data } = api.get(`/api/product/id/${productId}`);
        dispatch({ type: FIND_PRODUCT_BY_ID_SUCCESS, payload: data })

    } catch (error) {
        dispatch({ type: FIND_PRODUCT_BY_ID_FAILURE, payload: error.message })

    }
};
export const findProductsByCategory = (reqData) => async(dispatch) => {
    dispatch({ type: FIND_PRODUCT_BY_CATEGORY_REQUEST });
    console.log("Req Data :", reqData);
    const { colors, sizes, minPrice, maxPrice, minDiscount, category, stock, sort, pageNumber, pageSize } = reqData;
    console.log(`/api/products?color=${colors}&size=${sizes}&minPrice=${minPrice}&maxPrice=${maxPrice}&minDiscount=${minDiscount}&category=${category}&stock=${stock}&sort=${sort}&pageNumber=${pageNumber}&pageSize=${pageSize}`);
    try {
        const { data } = await api.get(`/api/products?color=${colors}&size=${sizes}&minPrice=${minPrice}&maxPrice=${maxPrice}&minDiscount=${minDiscount}&category=${category}&stock=${stock}&sort=${sort}&pageNumber=${pageNumber}&pageSize=${pageSize}`);

        dispatch({ type: FIND_PRODUCT_BY_CATEGORY_SUCCESS, payload: data })
        console.log("Data :", data);

    } catch (error) {
        dispatch({ type: FIND_PRODUCT_BY_CATEGORY_FAILURE, payload: error.message })

    }
};