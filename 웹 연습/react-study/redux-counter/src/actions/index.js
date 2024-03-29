/*
    action 객체를 만드는 액션 생성자들을 선언합니다. (action creators)
    여기서 () => ({}) 은, function() { return { } } 와 동일한 의미입니다.
    scope 이슈와 관계 없이 편의상 사용되었습니다.
*/


import * as types from './ActionTypes';

export const increment = () =>{
    return{
        type: types.INCREMENT
    }
}
export const decrement  = () =>{
    return{
        type:types.DECREMENT
    }
}
export const setColor = (color) => ({
    type: types.SET_COLOR,
    color
});