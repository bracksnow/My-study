import React from 'react';
import PropTypes from 'prop-types';
import './Counter.css';

const Counter = ({number, color, onIncrement, onDecrement, onSetColor}) =>{
    return(
        <div className = 'Counter' onClick = {onIncrement} onContextMenu = {(e)=>{
            //onContextMenu는 이벤트를 막는 역할을 한다.
            e.preventDefault();
            onDecrement();
        }} onDoubleClick = {onSetColor} style={{backgroundColor: color}}>
        {number}
        </div>
    );

}

Counter.propTypes = {
    //props의 타입을 지정한 것 만약 다른 값들이 입력이 되면 경고를 한다
    number: PropTypes.number,
    color: PropTypes.string,
    onIncrement: PropTypes.func,
    onDecrement: PropTypes.func,
    onSetColor: PropTypes.func
};

Counter.defaultProps = {
    //props를 따로 입력받지 넘겨받지 않으면 유지되는 props들
    number: 0,
    color: 'black',
    onIncrement: () => console.warn('onIncrement not defined'),
    onDecrement: () => console.warn('onDecrement not defined'),
    onSetColor: () => console.warn('onSetColor not defined')
};
export default Counter;