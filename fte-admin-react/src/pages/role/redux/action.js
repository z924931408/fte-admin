import axios from "../../../utils/axios";
import {message} from "antd";

export const type = {
    USER_LIST: 'USER_LIST',
    OPEN_ADD_ROLE: 'OPEN_ADD_ROLE',
    CLOSE_ADD_ROLE: 'CLOSE_ADD_ROLE',
    OPEN_EDIT_ROLE: 'OPEN_EDIT_ROLE',
    CLOSE_EDIT_ROLE: 'CLOSE_EDIT_ROLE',
    SET_EDIT_VALUE: 'SET_EDIT_VALUE'
};


export function setRoleList(data) {
    return {type: type.USER_LIST, data}
}

export function openAddRole() {
    return {type: type.OPEN_ADD_ROLE, data: "add"}
}

export function openEditRole() {
    return {type: type.OPEN_EDIT_ROLE, data: "edit"}
}


export function closeEditRole() {
    return {type: type.CLOSE_EDIT_ROLE, data: "edit"}
}

export function closeAddRole() {
    return {type: type.CLOSE_ADD_ROLE}
}


export function setEditValue(data) {
    return {type: type.SET_EDIT_VALUE, data}
}


/**
 * 获取用户信息
 * @param data
 * @returns {function(...[*]=)}
 */
export const getRoleList = (data = {}) => dispatch => {
    axios.get(
        "/sysRole/list",
        data
    ).then((res) => {
        if (res.code === 200) {
            console.log(res)
            dispatch(setRoleList(res.data))
        } else {
            message.error('账号或密码错误', 1);
        }
    })
}


/**
 * 删除角色信息
 * @param data
 * @returns {function(...[*]=)}
 */
export const deleteRole = (data = {}) => dispatch => {
    axios.post(
        "/sysRole/delete",
        {id: data.id}
    ).then((res) => {
        if (res.code === 200) {
            dispatch(getRoleList())
            message.success('删除成功');
        } else {
            message.error('删除失败');
        }
    })
}


