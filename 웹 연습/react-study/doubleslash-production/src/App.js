import React, { Component } from 'react';
import './App.css';
import Product from './Product'

class App extends Component{
  state = {

  }
  componentDidMount(){
    this._getProduct();
  }
  _getProduct = async () => {
    const products = await this._callProduct();
    this.setState({
      products
    });
  };
  _callProduct = ()=>{//Ajax를 이용해 받아오는 역할
    return fetch('https://yts.mx/api/v2/list_movies.json?sort_by=like_count')//비동기함수
    .then(response=>response.json())//fetch가 다 받아와야 돌아가도록 함
    .then(json=>json.data.movies)
    .catch(error=>console.log(error));//비동기함수
  }
  _renderProduct=()=>{
    const product = this.state.products.map((product, i)=>{//state에 입력된 것을 map을 이용해서 반복
      return <Product name={product.name} img = {product.img} ingredient = {product.ingredient} key = {i+product.name}></Product>
    })
    return product;
  }
  render(){
    return(
      <>
        <div className='App'>
          {this._renderProduct()}
        </div>
      </>
    );
  }
}
export default App;
