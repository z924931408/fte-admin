import {type} from './action';

const initialState = {
    roles: [],
    openAddRoleModal: false,
    modalType: 'add',
    editRoleValue: []
};

export default (state = initialState, action) => {
    switch (action.type) {

        case type.USER_LIST:
            return {
                ...state,
                roles: action.data
            };

        case type.OPEN_ADD_ROLE:

            return {
                ...state,
                openAddRoleModal: true,
                modalType: action.data
            }
        case type.CLOSE_ADD_ROLE:
            return {
                ...state,
                openAddRoleModal: false
            }

        case type.OPEN_EDIT_ROLE:
            return {
                ...state,
                openAddRoleModal: true,
                modalType: action.data
            }

        case type.CLOSE_EDIT_ROLE:
            return {
                ...state,
                openAddRoleModal: false
            }
        case type.SET_EDIT_VALUE:
            return {
                ...state,
                editRoleValue: action.data
            }


        default:
            return state;
    }
}
