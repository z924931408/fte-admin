import React from 'react';
import {Button, Divider, Table} from 'antd';
import {connect} from "react-redux";
import {deleteUser, getUserList, openAddUser, openEditUser, setEditValue} from "./redux/action";


@connect((state) => ({
    ...state.userReducer
}), {
    getUserList,
    openAddUser,
    deleteUser,
    openEditUser,
    setEditValue
})

class userList extends React.Component {
    state = {
        selectedRowKeys: [],
        loading: false,
    };


    componentDidMount() {
        this.props.getUserList()

    }


    addUser = () => {
        this.props.openAddUser();
    }

    deleteUser = (user) => {
        this.props.deleteUser(user)
    }

    editUser = (value) => {
        this.props.openEditUser();
        this.props.setEditValue(value)
    }

    render() {

        const {loading} = this.state;
        const {users} = this.props;

        const columns = [
            {
                title: '姓名',
                dataIndex: 'name',
            },
            {
                title: '昵称',
                dataIndex: 'nickName',
            },
            {
                title: '邮箱',
                dataIndex: 'email',
            },
            {
                title: '密码',
                dataIndex: 'password',
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
                <Table bordered={true} columns={columns} dataSource={users}/>
            </div>
        );
    }

}

export default userList
