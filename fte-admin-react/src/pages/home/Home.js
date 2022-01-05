import React from 'react';
import './home.css';
import { Icon } from 'antd';
var Highcharts = require('highcharts');
// 在 Highcharts 加载之后加载功能模块
require('highcharts/modules/exporting')(Highcharts);
class Home extends React.Component {

  state = {
    cartList: [{
      title: '新增用户数',
      number: '10',
      icon: 'user-add'
    }, {
      title: '累计访问',
      number: '11',
      icon: 'heart'
    }, {
      title: '分享统计',
      number: '12',
      icon: 'share-alt'
    }]
  };

  render() {
    return (
      <div className="home-warp">
        <div className="cart-list">
          {
            this.state.cartList.map((item) => {
              return (
                <div className="cart-item" key={item.title}>
                  <div className={ `cart-item-icon ${item.icon}` }>
                    <Icon type={ item.icon }/>
                  </div>
                  <div className="cart-item-content">
                    <div className="number">{ item.number }</div>
                    <div className="title">{ item.title }</div>
                  </div>
                </div>
              );
            })
          }
        </div>
        <div className="user-chart">
        
        </div>
      </div>
    );
  }

  componentDidMount() {

  }

}

export default Home
