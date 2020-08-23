import React, {useState, useCallback} from 'react';
import {Form, Input , Button, Checkbox} from 'antd';

export const useInput = (initialValue = null) =>{//커스텀 훅->반복되는 것을 줄일 수 있음
    const [value, setter] = useState(initialValue);
    const handler = useCallback((e) =>{
        setter(e.preventDefault());
    },[]);
    return [value, handler];
};
const Signup = () =>{
    //const [id,setId] = useState('');
    const [nick,setNick] = useState('');
    const [password,setPassword] = useState('');
    const [passwordCheck,setPasswordCheck] = useState('');
    const [term,setTerm] = useState(false);
    const [passwordError,setPasswordError] = useState(false);
    const [termError,setTermError] = useState(false);
    //props로 넘겨주는 함수들을 usecallback으로 묶어줘야함->state값이 변경되어 처음부터 랜더링하기 때문에 계속 함수객체가 생성되기 때문
    const onSubmit = useCallback((e) =>{
        e.preventDefault();
        if(password!==passwordCheck){
            return setPasswordError(true);
        }
        if(!term){
            return setTermError(true);
        }
    },[password, passwordError, termError])
    /*const onChangeId = (e) => {
        setId(e.target.value);
    };*/
    const onChangeNick = useCallback((e) => {
        setNick(e.target.value);
    }, [nick]);
    const onChangePassword = useCallback((e) => {
        setPassword(e.target.value);
    }, [password]);
    const onChangePasswordChk = useCallback((e) => {
        //비밀번호를 입력할때마다 password 를 검증하는 함수
        setPasswordError(e.target.value !== password);
        setPasswordCheck(e.target.value);
    }, [password, passwordCheck]);
    const onChangeTerm = useCallback((e) => {
        //체크박스 초기화
        setTermError(false);
        setTerm(e.target.checked);
    },[termError, term]);
    const [id, onChangeId] = useInput('');
    return (
        <>
            <Form onSubmit={onSubmit} style={{padding:10}}>
                <div>
                    <label htmlFor="user-id">아이디</label><br/>
                    <Input name="user-id" value={id} required onChange={onChangeId} />
                </div>
                <div>
                    <label htmlFor="user-nick">닉네임</label><br/>
                    <Input name="user-nick" value={nick} required onChange={onChangeNick} />
                </div>
                <div>
                    <label htmlFor="user-password">비밀번호</label><br/>
                    <Input name="user-password" type="password" value={password} required onChange={onChangePassword} />
                </div>
                <div>
                    <label htmlFor="user-password-check">비밀번호체크</label><br/>
                    <Input name="user-password-check" type="password" value={passwordCheck} required onChange={onChangePasswordChk} />
                    {passwordError && <div style={{color : 'red'}}>비밀번호가 일치하지 않습니다.</div>}
                </div>
                <div>
                    <Checkbox name="user-term" checked={term} onChange={onChangeTerm}>동의합니까?</Checkbox>
                    {termError && <div style={{color : 'red'}}>약관에 동의해야 합니다.</div>}
                </div>
                <div style={{marginTop:10}}>
                    <Button type="primary" htmlType="submit" >가입하기</Button>
                </div>
                </Form>
        </>
    );
};

export default Signup;