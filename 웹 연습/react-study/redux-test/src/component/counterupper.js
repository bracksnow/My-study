import React, {Component, Fragement} from 'react';
import { connect } from 'react-redux'
import { increase, decrease } from '../actions'

class CU extends Component {
    render() {
      return (
          <div>
              <button type = "button" onClick = {this.props.onDecrease}>-</button> 
          </div>
      );
  }
}

let mapDispatchToProps = (dispatch) => {
    return {
        onDecrease: () => dispatch(decrease())
    }
}

CU = connect(undefined, mapDispatchToProps)(CU);

export default CU;