import React from 'react';
import {Redirect, Route, Switch} from 'react-router-dom';
import './app.css';
// import home from './pages/wxread/Home';
import login from './pages/login/Login';
import Main from './routes/index';

class App extends React.Component {
    render() {
        return (
            <div className="App">
                <Switch>
                    <Route path="/login" component={login}/>
                    <Route path="/" component={Main}/>
                    <Redirect to="/"/>
                </Switch>
            </div>
        );
    }
}

export default App;
