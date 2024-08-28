import api from '../../config/apiConfig';
import { CREATE_ORDER_FAILURE, CREATE_ORDER_REQUEST } from './ActionTypes';

export const createOrder = (reqData) => async(dispatch) => {
        try {
            dispatch({ type: CREATE_ORDER_REQUEST })
            const config = {
                headers: {
                    "Content-Type": "application/json",
                    Authorization: `Bearer ${reqData.jwt}`,
                },
            };
            const { data } =
            await axios.post(`${API_BASE_URL}/api/orders/`,
                reqData.address, config);

            dispatch({ type: CREATE_ORDER_SUCCESS, payload: data });

        }