import React from 'react';
import {Form, Input, message, Modal,} from 'antd';
import {connect} from "react-redux";
import {closeAddRole, getRoleList} from "./redux/action";
import axios from "../../utils/axios";


@Form.create()
@connect((state) => ({
    ...state.roleReducer
}), {
    closeAddRole,
    getRoleList
})
class updateRoleModal extends React.Component {
    state = {
        loading: false,
        visible: false,
        confirmDirty: false,
        autoCompleteResult: [],

        formItemLayout: {
            labelCol: {
                xs: {span: 18},
                sm: {span: 5},
            },
            wrapperCol: {
                xs: {span: 24},
                sm: {span: 16},
            },
        }
    };


    componentDidMount() {

    }


    handleCancel = e => {
        this.props.closeAddRole()
    };


    handleSubmit = e => {
        const {modalType, editRoleValue} = this.props;

        e.preventDefault();
        this.props.form.validateFieldsAndScroll((err, values) => {
            if (!err) {
                if (modalType === 'add') {
                    axios.post(
                        "/sysRole/add",
                        values
                    ).then((res) => {
                        if (res.code === 200) {
                            this.props.getRoleList()
                            this.props.closeAddRole()
                            message.success('添加成功');
                        } else {
                            message.error('账号或密码错误', 1);
                        }
                    })
                } else {

                    values.id = editRoleValue.id;

                    axios.post(
                        "/sysRole/edit",
                        values
                    ).then((res) => {
                        if (res.code === 200) {
                            this.props.getRoleList()
                            this.props.closeAddRole()
                            message.success('添加成功');
                        } else {
                            message.error('账号或密码错误', 1);
                        }
                    })
                }
            }
        });
    };


    render() {
        const {openAddRoleModal, form, modalType, editRoleValue} = this.props
        const {getFieldDecorator} = form;
        const {formItemLayout} = this.state


        return (
            <Modal
                title={modalType === 'add' ? '添加' : '编辑'}
                visible={openAddRoleModal}
                onOk={this.handleSubmit}
                onCancel={this.handleCancel}
            >

                <Form {...formItemLayout} onSubmit={this.handleSubmit}>
                    <Form.Item label="角色名"
                    >
                        {getFieldDecorator('name', {
                            rules: [{required: true, message: 'Please input your name!', whitespace: true}],
                            initialValue: modalType === 'add' ? "" : editRoleValue.name !== undefined ? editRoleValue.name : ''
                        })(<Input/>)}
                    </Form.Item>


                    <Form.Item label="备注" hasFeedback>
                        {getFieldDecorator('remark', {
                            rules: [
                                {
                                    required: true,
                                    message: 'Please input your password!',
                                },
                            ],
                            initialValue: modalType === 'remark' ? "" : editRoleValue.remark !== undefined ? editRoleValue.remark : ''
                        })(<Input/>)}
                    </Form.Item>

                </Form>
            </Modal>
        );
    }

}

export default updateRoleModal
