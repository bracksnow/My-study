import React, { useState } from 'react';

const SignUp = () =>{
    const [name, setName] = useState('');
    const [id,setId] = useState('');
    const [password, setPassword] = useState('');
    const [nickname, setNickname] = useState('');
    const [passwordCheck, setPasswordCheck] = useState('');
    const [check, setCheckError] = useState(false);
    const onSubmit = (e)=>{
        e.preventDefault();
        if(password !== passwordCheck){
            return setCheckError(true);
        }else{
            return setCheckError(false);
        }
    }
    const onChangeId = (e) =>{
        setId(e.target.value);
    }
    const onChangeName = (e)=>{
        setName(e.target.value)
    }

    const onChangeNick = (e) =>{
        setNickname(e.target.value);
    }
    const onChangePassword = (e) =>{
        setPassword(e.target.value);
    }
    const onChangePasswordChk = (e) =>{
        setPasswordCheck(e.target.value);
    }
    return(
        <>
        <form onSubmit = {onSubmit}>
            <div>
                <label htmlFor="user-name">이름</label><br/>
                <input name="user-name" value={name} required onChange = {onChangeName} />
            </div>
            <div>
                <label htmlFor="user-id">아이디</label><br/>
                <input name="user-id" value={id} required onChange = {onChangeId} />
            </div>
            <div>
                <label htmlFor="user-nick">닉네임</label><br/>
                <input name="user-nick" value={nickname} required onChange={onChangeNick} />
            </div>
            <div>
                <label htmlFor="user-password">비밀번호</label><br/>
                <input name="user-password" type="password" value={password} required onChange={onChangePassword} />
            </div>
            <div>
                <label htmlFor="user-password-check">비밀번호체크</label><br/>
                <input name="user-password-check" type="password" value={passwordCheck} required onChange={onChangePasswordChk} />
                {check===true && <div style={{color : 'red'}}>비밀번호가 일치하지 않습니다.</div>}
                {/*&&을 통해서 if문을 구성할 수 있다, &&다음에 참이면 실행됨*/}
            </div>
            <div style={{marginTop:10}}>
                <button htmlType="submit" >가입하기</button>
            </div>
        </form>
        </>
    )
}
export default SignUp;