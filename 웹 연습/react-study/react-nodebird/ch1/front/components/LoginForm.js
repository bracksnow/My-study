import React, { useCallback } from 'react';
import {Input, Form, Button, List} from 'antd';
import Link from 'next/link';
import { useInput } from '../pages/signup';
import {useDispatch} from "react-redux";
import {loginAction} from '../reducers/user'

const LoginForm = () => {
    const [id , onChangeId] = useInput('');
    const [password , onChangePassword] = useInput('');
    const dispatch = useDispatch();
    const onSubmitForm = useCallback((e) => {
        e.preventDefault();
        dispatch(loginAction);
    },[id,password]);
    //자식컴포넌트로 넘기는 함수는 무조건 usecallback로 감싸준다
    return (
        <Form onSubmit={onSubmitForm}>
            <div>
                <label htmlFor="user-id">아이디</label>
                <br />
                <Input name="user-id" value={id} onChange={onChangeId} />
            </div>
            <div>
                <label htmlFor="user-id">비밀번호</label>
                <br />
                <Input name="user-id" type="password"  value={password} onChange={onChangePassword} />
            </div>
            <div  style={{marginBottom : '10px'}}>
                <Button type="primary" htmlType="submit" loading={false} >로그인</Button>
                <Link href="/signup"><a><Button>회원가입</Button></a></Link>
            </div>
        </Form>
    );
}
export default LoginForm;