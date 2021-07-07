import React from 'react';
import {connect} from "react-redux";
import UserList from './menuList'
import AddUserModal from './updateMenuModal'

@connect((state) => ({
    ...state.menuReducer,

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
