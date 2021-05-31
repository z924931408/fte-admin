import React from 'react';
import {Button, Divider, Table} from 'antd';
import {connect} from "react-redux";
import {deleteRole, getRoleList, openAddRole, openEditRole, setEditValue} from "./redux/action";


@connect((state) => ({
    ...state.roleReducer
}), {
    getRoleList,
    openAddRole,
    deleteRole,
    openEditRole,
    setEditValue
})

class roleList extends React.Component {
    state = {
        selectedRowKeys: [],
        loading: false,
    };


    componentDidMount() {
        this.props.getRoleList()

    }


    addUser = () => {
        this.props.openAddRole();
    }

    deleteUser = (user) => {
        this.props.deleteRole(user)
    }

    editUser = (value) => {
        this.props.openEditRole();
        this.props.setEditValue(value)
    }

    render() {

        const {loading} = this.state;
        const {roles} = this.props;

        const columns = [
            {
                title: '角色名',
                dataIndex: 'name',
            },
            {
                title: '备注',
                dataIndex: 'remark',
            },


            {
                title: 'Action',
                key: 'action',
                render: (text, record) => (
                    <span>
                         <a onClick={this.editUser.bind(this, text)}>编辑</a>
                            <Divider type="vertical"/>
                         <a onClick={this.deleteUser.bind(this, text)}>删除</a>
                    </span>
                ),
            },
        ];
        return (
            <div className="content-wrap">
                <div style={{marginBottom: 16}}>
                    <Button type="primary" onClick={this.addUser} loading={loading}>
                        添加
                    </Button>
                </div>
                <Table bordered={true} columns={columns} dataSource={roles}/>
            </div>
        );
    }

}

export default roleList
