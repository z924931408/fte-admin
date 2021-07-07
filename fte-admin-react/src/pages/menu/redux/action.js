import axios from "../../../utils/axios";
import {message} from "antd";

export const type = {

    OPEN_ADD_USER: 'OPEN_ADD_USER',
    CLOSE_ADD_USER: 'CLOSE_ADD_USER',
    OPEN_EDIT_USER: 'OPEN_EDIT_USER',
    CLOSE_EDIT_USER: 'CLOSE_EDIT_USER',
    SET_EDIT_VALUE: 'SET_EDIT_VALUE',


    MENU_LIST: 'MENU_LIST',
    SWITCH_MENU: 'SWITCH_MENU'
};


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

            message.success('删除成功');
        } else {
            message.error('删除失败');
        }
    })
}


/**
 * 获取菜单信息
 * @param data
 * @returns {function(...[*]=)}
 */

export const getMenuList = (data = {}) => dispatch => {
    axios.get(
        "/sysMenu/list",
        data
    ).then((res) => {
        if (res.code === 200) {
            dispatch(setMenuList(res.data))
        }
    })
}

export function setMenuList(data) {
    return {type: type.MENU_LIST, data}
}


export function switchMenu(menuName) {
    return {
        type: type.SWITCH_MENU,
        menuName
    }
}
