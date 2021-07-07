import React from 'react';
import {Button, Divider, Table} from 'antd';
import {connect} from "react-redux";
import {deleteUser, getMenuList, openAddUser, openEditUser, setEditValue} from "./redux/action";


@connect((state) => ({
    ...state.menuReducer
}), {
    getMenuList,
    openAddUser,
    deleteUser,
    openEditUser,
    setEditValue
})

class menuList extends React.Component {
    state = {
        selectedRowKeys: [],
        loading: false,
    };


    componentDidMount() {
        this.props.getMenuList()

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
        const {menus} = this.props;

        const columns = [
            {
                title: '编号',
                dataIndex: 'id',
            },
            {
                title: '菜单名称',
                dataIndex: 'title',
            },
            {
                title: '父菜单ID',
                dataIndex: 'parentId',
            },
            {
                title: '菜单url',
                dataIndex: 'url',
            },
            {
                title: '授权',
                dataIndex: 'accredit',
            },
            {
                title: '类型',
                dataIndex: 'types',
            },
            {
                title: '菜单图标',
                dataIndex: 'icon',
            },
            {
                title: '排序',
                dataIndex: 'orderNum',
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
                <Table bordered={true} columns={columns} dataSource={menus}/>
            </div>
        );
    }

}

export default menuList
