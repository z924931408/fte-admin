import React from 'react';
import {connect} from "react-redux";
import RoleList from './roleList'
import AddRoleModal from './updateRoleModal'

@connect((state) => ({
    ...state.roleReducer
}), {})

class index extends React.Component {
    state = {
        selectedRowKeys: [],
        loading: false,
    };


    render() {
        return (
            <div>
                <AddRoleModal/>
                <RoleList/>
            </div>
        );
    }

}

export default index
