import React, {Component} from 'react';
import AppNumber from '../containers/AddNumber'
class AppNumberRoot extends Component{
    render(){
      return(
        <div>
          <h1>Add Number Root</h1>
          <AppNumber></AppNumber>
        </div>
      );
    }
  }

export default AppNumberRoot