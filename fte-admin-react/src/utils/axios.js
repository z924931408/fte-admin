import axios from 'axios'
import {message, Spin} from 'antd';
import React from 'react';
import ReactDOM from 'react-dom';
import qs from 'querystring'
import '../app.css';


// 默认域名
axios.defaults.baseURL = "http://127.0.0.1:8095/fte/";
// 配置请求头
axios.defaults.headers["Content-Type"] = "application/x-www-form-urlencoded";
// 响应时间
axios.defaults.timeout = 10000;

// 获取缓存中的用户信息, 这是接口返回的信息。
var token;

function getUser() {

    if (localStorage.getItem('token')) {
        token = localStorage.getItem('token');

    }
}

//请求拦截器
axios.interceptors.request.use(
    config => {

        showLoading();//显示加载动画
        getUser();//获取用户信息
        if (token) {

            // 设置统一的请求header
            config.headers.Authorization = token //授权(每次请求把token带给后台)
        } else {

            // this.props.history.push('/login');
        }
        // config.headers.platform = user ? user.platform : 8 //后台需要的参数
        return config;
    },
    error => {
        hideLoading();//关闭加载动画
        return Promise.reject(error);
    }
);

//响应拦截器
axios.interceptors.response.use(
    response => {
        hideLoading();//关闭加载动画
        if (response.data.returnCode === '0014') { // 登录失效
            localStorage.clear(); // 清除缓存
            message.success({
                content: '您的登录已经失效，请重新登录',
                duration: 2
            });
            setTimeout(() => {
                //让用户从新回到登录页面
                window._ROUTER_.push('/login');//router是在顶级入口app.js文件定义了window._ROUTER_ = this.props.history;
            }, 2000)
        }
        return response;
    },
    error => {
        hideLoading();//关闭加载动画
        return Promise.resolve(error.response);
    }
);

// 处理请求返回的数据
function checkStatus(response) {
    return new Promise((resolve, reject) => {
        if (response && (response.status === 200 || response.status === 304 || response.status === 400)) {
            resolve(response.data);
        } else {
            message.success({
                content: '网络异常，请检查网络连接是否正常！',
                duration: 2
            });
        }
    });
}

export default {
    post(url, params) {
        return axios({
            method: "post",
            url,
            data: qs.stringify(params)
        }).then(response => {
            return checkStatus(response);
        });
    },
    get(url, params) {
        return axios({
            method: "get",
            url,
            params,
        }).then(response => {
            return checkStatus(response);
        });
    }
};


// 显示加载动画
function showLoading() {
    let dom = document.createElement('div')
    dom.setAttribute('id', 'loading')
    document.body.appendChild(dom)
    ReactDOM.render(<Spin tip="加载中..." size="large"/>, dom)
}

// 隐藏加载动画
function hideLoading() {
    document.body.removeChild(document.getElementById('loading'))
}