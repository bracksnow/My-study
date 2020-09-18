import {all, fork,call, put, takeLatest} from 'redux-saga/effects';
import {LOG_IN, LOGIN_FAILURE, LOGIN_SUCCESS} from "../reducers/user";

function loginApi(){
    //서버와 통신하는 부분을 구현할 함수부분
}

function* login(){
    try{
        yield call(loginApi());
        yield put({
            type:LOGIN_SUCCESS
        })
    }catch (e){
        console.log(e);
        yield put({
            type:LOGIN_FAILURE
        })
    }

}

function* watchLogin(){
    takeLatest(LOG_IN, login);
}

export default function* userSaga(){
    yield all([
        fork(watchLogin)
    ]);
}