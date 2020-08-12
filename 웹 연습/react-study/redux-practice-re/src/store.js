import {createStore} from 'redux';

const initialState = {
    number:0
}
export default createStore((state=initialState, action)=>{
    if(action.type==='INCREMENT'){
        return{
            ...state, number:state.number+action.size
        }
    }
    return state;

},window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

//처음에 store를 생성해서 그 안에 reducer를 넣어준다
//state는 초기값을 넣어야한다.