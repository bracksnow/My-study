import React, {Component} from  'react';
import DisplayNumber from '../containers/DisplayNumber'
class DisplayNumberRoot extends Component{
    render(){
      return(
        <div>
          <h1>DisplayRoot Number Root</h1>
          <DisplayNumber number = {this.props.number}></DisplayNumber>
        </div>
      );
    }
  }
export default DisplayNumberRoot;