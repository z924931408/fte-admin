import React from 'react';
import {connect} from "react-redux";
import UserList from './userList'
import AddUserModal from './updateUserModal'

@connect((state) => ({
    ...state.userReducer
}), {})

class index extends React.Component {
    state = {
        selectedRowKeys: [],
        loading: false,
    };


    render() {
        return (
            <div>
                <AddUserModal/>
                <UserList/>
            </div>
        );
    }

}

export default index
