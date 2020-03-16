import React from 'react';
const Try = ({tryinfo})=>{
    return(
        <>
        <li>
            <div>{tryInfo.try}</div>
            <div>{tryInfo.result}</div>
        </li>
        </>

    );
}
//그냥 {tryinfo}라는 구조분해를 넣어도 되고 props도 사용가능, 단 그런 경우에는 props.tryinfo.try로 변경해야함