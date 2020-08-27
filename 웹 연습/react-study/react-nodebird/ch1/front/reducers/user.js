const dummyUser = {
    nickname:'gwon',
    Post:[],
    Followings:[],
    Followers:[],
}
export const initialState = {
    isLoggedIn:false,
    user:null,
}//초기 state를 만들어준다

export const LOG_IN = 'LOG_IN';//액션의 이름->대문자로 적어준다
export const LOG_OUT = 'LOG_OUT';

export const loginAction = {
    type:LOG_IN,
    data:{
        nickname:'gwon',
    }
};
export const logoutAction = {
    type:LOG_OUT,

}

const reducer = (state = initialState, action) =>{
    switch (action.type){
        case LOG_IN:{
            return{
                ...state,isLoggedIn: true, user:dummyUser
            }
        }
        case LOG_OUT:{
            return{
                ...state, isLoggedIn: false, user:null
            }
        }
        default:{
            return{
                ...state
            }
        }
    }
};
export default reducer;
