import axios from "../../../utils/axios";
import {message} from "antd";

export const type = {
    USER_LIST: 'USER_LIST',
    OPEN_ADD_USER: 'OPEN_ADD_USER',
    CLOSE_ADD_USER: 'CLOSE_ADD_USER',
    OPEN_EDIT_USER: 'OPEN_EDIT_USER',
    CLOSE_EDIT_USER: 'CLOSE_EDIT_USER',
    SET_EDIT_VALUE: 'SET_EDIT_VALUE'
};


export function setUserList(data) {
    return {type: type.USER_LIST, data}
}

export function openAddUser() {
    return {type: type.OPEN_ADD_USER, data: "add"}
}

export function openEditUser() {
    return {type: type.OPEN_EDIT_USER, data: "edit"}
}


export function closeEditUser() {
    return {type: type.CLOSE_EDIT_USER, data: "edit"}
}

export function closeAddUser() {
    return {type: type.CLOSE_ADD_USER}
}


export function setEditValue(data) {
    return {type: type.SET_EDIT_VALUE, data}
}


/**
 * 获取用户信息
 * @param data
 * @returns {function(...[*]=)}
 */
export const getUserList = (data = {}) => dispatch => {
    axios.get(
        "/sysUser/list",
        data
    ).then((res) => {
        if (res.code === 200) {
            console.log(res)
            dispatch(setUserList(res.data))
        } else {
            message.error('账号或密码错误', 1);
        }
    })
}


/**
 * 删除用户信息
 * @param data
 * @returns {function(...[*]=)}
 */
export const deleteUser = (data = {}) => dispatch => {
    axios.post(
        "/sysUser/delete",
        {id: data.id}
    ).then((res) => {
        if (res.code === 200) {
            dispatch(getUserList())
            message.success('删除成功');
        } else {
            message.error('删除失败');
        }
    })
}


