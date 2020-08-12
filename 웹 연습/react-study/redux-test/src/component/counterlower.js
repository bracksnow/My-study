import React, {Component, Fragement} from 'react'
import { connect } from 'react-redux'
import { increase, decrease } from '../actions'

class CL extends Component {
    render() {
      return (
          <div>
              <button type = "button" onClick = {this.props.onIncrease}>+</button> 
          </div>
      );
    }
  }

let mapDispatchToProps = (dispatch) => {
    return {
        onIncrease: () => dispatch(increase())
    }
}

CL = connect(undefined, mapDispatchToProps)(CL);

export default CL;