const initialState = {
    isLoggedIn:false,
    user:{},
}//초기 state를 만들어준다

const LOG_IN = 'LOG_IN';//액션의 이름->대문자로 적어준다
const LOG_OUT = 'LOG_OUT';

const loginAction = {
    type:LOG_IN,
    data:{
        nickname:'gwon',
    }
};
const logoutAction = {
    type:LOG_OUT,

}

const reducer = (state = initialState, action) =>{
    switch (action.type){
        case LOG_IN:{
            return{
                ...state,isLoggedIn: true, user:action.data
            }
        }
        case LOG_OUT:{
            return{
                ...state, isLoggedIn: false, user:null
            }
        }
    }
}