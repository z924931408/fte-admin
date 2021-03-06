import React, {lazy, Suspense} from 'react';
import {Layout} from "antd";
import {Redirect, Route, Switch} from 'react-router-dom';

const SiderBar = lazy(() => import(/* webpackChunkName: "layout" */ '../components/layout/SiderBar'));
const HeaderBar = lazy(() => import(/* webpackChunkName: "layout" */ '../components/layout/HeaderBar'));
const Home = lazy(() => import(/* webpackChunkName: "home" */ '../pages/home/Home'));
// const Connect = lazy(() => import(/* webpackChunkName: "connect" */ '../pages/user/connect/Connect'));
const List = lazy(() => import(/* webpackChunkName: "roleList" */ '../pages/user'));
const Rich = lazy(() => import(/* webpackChunkName: "rich" */ '../pages/tool/rich'));
const NotFind = lazy(() => import(/* webpackChunkName: "notFind" */ '../pages/notFind/NotFind'));
const Role = lazy(() => import(/* webpackChunkName: "role" */ '../pages/role'));
const Menu = lazy(() => import(/* webpackChunkName: "menu" */ '../pages/menu'));

class Index extends React.Component {

    render() {
        const loggedIn = window.localStorage.getItem('loggedIn');
        const mainPage = (
            <Layout>
                <Suspense fallback={<div>Loading...</div>}>
                    <SiderBar></SiderBar>
                    <Layout>
                        <HeaderBar history={this.props.history}></HeaderBar>
                        <div className="layout-content">

                            <Switch>
                                <Route exact path="/" component={Home}/>
                                <Route path="/system/role" component={Role}/>
                                <Route path="/system/user" component={List}/>

                                <Route path="/system/menu" component={Menu}/>
                                <Route path="/tool/rich" component={Rich}/>
                                <Route component={NotFind}/>
                            </Switch>

                        </div>
                    </Layout>
                </Suspense>
            </Layout>
        );
        return (
            loggedIn ? (
                mainPage
            ) : (
                <Redirect to="/login"/>
            )
        );
    }
}

export default Index;
