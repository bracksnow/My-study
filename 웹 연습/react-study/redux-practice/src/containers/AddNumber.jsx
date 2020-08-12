import AddNumber from '../components/AppNumber';
import React, {Component} from 'react';
import {connect} from 'react-redux';

const mapReduxDispatchToReactProps = (dispatch)=>{
    return{
        onClick:(size)=>{
            dispatch({type:'INCREMENT', size:size})
        }
    }

}
export default connect(null, mapReduxDispatchToReactProps)(AddNumber);
//connect에 두번째 인자로 컴포넌트를 만들면 해당 컴포넌트의 presentational component를 만듦

/*
export default class extends Component{
    render(){
        return(
            <AddNumber onClick = {(size)=>{
                store.dispatch({type:'INCREMENT', size:size})
            }}></AddNumber>
        );
    }
}
*/