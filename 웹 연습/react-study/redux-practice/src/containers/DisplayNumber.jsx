import React, {Component} from 'react';
import DisplayNumber from '../components/DisplayNumber';
import {connect} from 'react-redux';
const mapReduxStateToReactProps = (state) =>{
  //리덕스의 state를 react의 props로 연결
  return{
      number:state.number
  }

}
export default connect(mapReduxStateToReactProps,)(DisplayNumber);
/*
export default class extends Component {
  state = {number:store.getState().number}
  constructor(props){
    super(props);
    store.subscribe(()=>{
      this.setState({number:store.getState().number})
    });
  }
    render() {
      return (
        <div>
        <DisplayNumber number = {this.state.number}></DisplayNumber>
        </div>
      )
    }
  }
  */

