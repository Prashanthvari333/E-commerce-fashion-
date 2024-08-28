const initialState = {
    user: null,
    loading: false,
    error: null,
    jwt: null,
}

export const authReducer = (state = initialState, action) => {
    switch (action.type) {
        case 'REGISTER_REQUEST':
            return {...state, loading: true, error: null }
        case 'REGISTER_SUCCESS':
            return {...state, loading: false, user: action.payload, error: null }
        case 'REGISTER_FAILURE':
            return {...state, loading: false, error: action.payload, user: null }
        case 'LOGIN_REQUEST':
            return {...state, loading: true, error: null }
        case 'LOGIN_SUCCESS':
            return {...state, loading: false, error: null, jwt: action.payload }
        case 'LOGIN_FAILURE':
            return {...state, loading: false, error: action.payload, user: null }
        case 'GET_USER_REQUEST':
            return {...state, loading: true, error: null }
        case 'GET_USER_SUCCESS':
            return {...state, loading: false, user: action.payload, error: null }
        case 'GET_USER_FAILURE':
            return {...state, loading: false, error: action.payload, user: null }
        case 'LOGOUT':
            return {...initialState }
        default:
            return state;
    }
}