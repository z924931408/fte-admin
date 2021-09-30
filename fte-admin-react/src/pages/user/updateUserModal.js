import React from 'react';
import {Form, Icon, Input, message, Modal, Tooltip,} from 'antd';
import {connect} from "react-redux";
import {closeAddUser, getUserList} from "./redux/action";
import axios from "../../utils/axios";


@Form.create()
@connect((state) => ({
    ...state.userReducer
}), {
    closeAddUser,
    getUserList
})
class updateUserModal extends React.Component {
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
        this.props.closeAddUser()
    };


    handleSubmit = e => {
        const {modalType, editUserValue} = this.props;

        e.preventDefault();
        this.props.form.validateFieldsAndScroll((err, values) => {
            if (!err) {
                if (modalType === 'add') {
                    axios.post(
                        "/sysUser/add",
                        values
                    ).then((res) => {
                        if (res.code === 200) {
                            this.props.getUserList()
                            this.props.closeAddUser()
                            message.success('添加成功');
                        } else {
                            message.error('账号或密码错误', 1);
                        }
                    })
                } else {

                    values.id = editUserValue.id;
                    
                    axios.post(
                        "/sysUser/edit",
                        values
                    ).then((res) => {
                        if (res.code === 200) {
                            this.props.getUserList()
                            this.props.closeAddUser()
                            message.success('添加成功');
                        } else {
                            message.error('账号或密码错误', 1);
                        }
                    })
                }
            }
        });
    };

    handleConfirmBlur = e => {
        const {value} = e.target;
        this.setState({confirmDirty: this.state.confirmDirty || !!value});
    };

    compareToFirstPassword = (rule, value, callback) => {
        const {form} = this.props;
        if (value && value !== form.getFieldValue('password')) {
            callback('Two passwords that you enter is inconsistent!');
        } else {
            callback();
        }
    };

    validateToNextPassword = (rule, value, callback) => {
        const {form} = this.props;
        if (value && this.state.confirmDirty) {
            form.validateFields(['confirm'], {force: true});
        }
        callback();
    };


    render() {
        const {openAddUserModal, form, modalType, editUserValue} = this.props
        const {getFieldDecorator} = form;
        const {formItemLayout} = this.state


        return (
            <Modal
                title={modalType === 'add' ? '添加' : '编辑'}
                visible={openAddUserModal}
                onOk={this.handleSubmit}
                onCancel={this.handleCancel}
            >

                <Form {...formItemLayout} onSubmit={this.handleSubmit}>
                    <Form.Item label="姓名"
                    >
                        {getFieldDecorator('name', {
                            rules: [{required: true, message: 'Please input your name!', whitespace: true}],
                            initialValue: modalType === 'add' ? "" : editUserValue.name !== undefined ? editUserValue.name : ''
                        })(<Input/>)}
                    </Form.Item>
                    <Form.Item
                        label={
                            <span>
                                昵称&nbsp;
                                <Tooltip title="What do you want others to call you?">
                                    <Icon type="question-circle-o"/>
                                 </Tooltip>
                            </span>
                        }
                    >
                        {getFieldDecorator('nickName', {
                            rules: [{required: true, message: 'Please input your nickname!', whitespace: true}],
                            initialValue: modalType === 'add' ? "" : editUserValue.nickName !== undefined ? editUserValue.nickName : ''
                        })(<Input/>)}
                    </Form.Item>

                    <Form.Item label="邮箱">
                        {getFieldDecorator('email', {
                            rules: [
                                {
                                    type: 'email',
                                    message: 'The input is not valid E-mail!',
                                },
                                {
                                    required: true,
                                    message: 'Please input your E-mail!',
                                },
                            ],

                            initialValue: modalType === 'add' ? "" : editUserValue.email !== undefined ? editUserValue.email : ''
                        })(<Input/>)}
                    </Form.Item>
                    <Form.Item label="密码" hasFeedback>
                        {getFieldDecorator('password', {
                            rules: [
                                {
                                    required: true,
                                    message: 'Please input your password!',
                                },
                                {
                                    validator: this.validateToNextPassword,
                                },
                            ],
                            initialValue: modalType === 'add' ? "" : editUserValue.password !== undefined ? editUserValue.password : ''
                        })(<Input.Password/>)}
                    </Form.Item>
                    <Form.Item label="确认密码" hasFeedback>
                        {getFieldDecorator('confirm', {
                            rules: [
                                {
                                    required: true,
                                    message: 'Please confirm your password!',
                                },
                                {
                                    validator: this.compareToFirstPassword,
                                },
                            ],
                            initialValue: modalType === 'add' ? "" : editUserValue.password !== undefined ? editUserValue.password : ''
                        })(<Input.Password onBlur={this.handleConfirmBlur}/>)}
                    </Form.Item>
                </Form>
            </Modal>
        );
    }

}

export default updateUserModal
