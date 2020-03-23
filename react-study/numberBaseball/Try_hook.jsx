import React from 'react';
const Try = ({tryinfo}) =>{//괄호자리는 props의 자리
    return(
        <li>
        <div>{tryInfo.try}</div>
        <div>{tryInfo.result}</div>
        </li>
    );
}
export default Try;