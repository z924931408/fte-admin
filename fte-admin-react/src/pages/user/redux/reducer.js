import {type} from './action';

const initialState = {
    users: [],
    openAddUserModal: false,
    modalType: 'add',
    editUserValue: []
};

export default (state = initialState, action) => {
    switch (action.type) {

        case type.USER_LIST:
            return {
                ...state,
                users: action.data
            };

        case type.OPEN_ADD_USER:

            return {
                ...state,
                openAddUserModal: true,
                modalType: action.data
            }
        case type.CLOSE_ADD_USER:
            return {
                ...state,
                openAddUserModal: false
            }

        case type.OPEN_EDIT_USER:
            return {
                ...state,
                openAddUserModal: true,
                modalType: action.data
            }

        case type.CLOSE_EDIT_USER:
            return {
                ...state,
                openAddUserModal: false
            }
        case type.SET_EDIT_VALUE:
            return {
                ...state,
                editUserValue: action.data
            }


        default:
            return state;
    }
}
