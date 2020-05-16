import React, {Component, createRef} from 'react';
import Try from './Try';
function getNumbers(){
    const candidate = [1,2,3,4,5,6,7,8,9];
    const array = [];
    for (let i = 0; i < 4; i += 1) {
      const chosen = candidate.splice(Math.floor(Math.random() * (9 - i)), 1)[0];
      array.push(chosen);
    }
    return array;
}
class numberBaseball extends Component{
    state = {
        result:'',
        value:'',
        answer:getNumbers(),//ex) 1,3,5,7
        tries:[],//push 불가능 ->리액트의 불변성때문
        //리액트는 참조를 기준으로 랜더링을 하기 때문에 기존 배열에 값을 넣어주면 다시 랜더링을 하지 않음
        //이것을 해결하기 위해선 const array2 = [array,1];과 같이 기존의 배열을 넣어서 새로운 배열을 만드는 방법으로 해결할 수 있다
    }
    onSubmitForm = (e) =>{
        const {value, tries, answer} = this.state;
        e.preventDefault();
        if(value===answer.join('')){
            this.setState((prevState) => {
              return{
                result:'홈런',
                tries:[...prevState.tries,{try:value, result:'홈런'}]//옛날에 사용한 값을 다시 배열에 넣는 것이기 때문에 옛날의 state를 사용할때는 state안에 함수사용
              };
                //리액트는 랜더링을 참조를 기준으로 함 
            });
            alert('게임을 다시 시작합니다!');
            this.setState({
              value: '',
              answer: getNumbers(),
              tries: [],
            });
            this.inputRef.current.focus();
        }else{//답이 틀린 경우
            const answerArray = value.split('').map((v)=>parseInt(v));
            let strike = 0;
            let ball = 0;
            if(tries.length>9){
                this.setState({
                    result: `10번 넘게 틀려서 실패! 답은 ${answer.join(',')}였습니다!`,
                });
                alert('게임을 다시 시작합니다!');
                this.setState({
                  value: '',
                  answer: getNumbers(),
                  tries: [],
                });
                this.inputRef.current.focus();
              } else {
                for (let i = 0; i < 4; i += 1) {
                  if (answerArray[i] === answer[i]) {
                    strike += 1;
                  } else if (answer.includes(answerArray[i])) {
                    ball += 1;
                  }
                }
                this.setState((prevState)=>{
                  return{
                    result:'',
                    tries:[...prevState.tries,{try:value, result: `${strike} 스트라이크, ${ball} 볼입니다`}]
                  }

                });
                this.inputRef.current.focus();
            }

        }

    };
    onChangeInput = (e) => {
        console.log(this.state.answer);
        this.setState({
          value: e.target.value,
        });
      };
    inputRef = createRef();//ref를 미세하게 움직이는 것을 포기하는 대신 간편하게 만들 수 있음
    //비구조화 할당이란 객체에서 result와 value, tries를 찾아서 하나의 변수처럼 사용되는 것을 말한다
    //리액트에선 state객체에서 찾아서 변수처럼 사용할 수 있도록 한다, 코드를 줄일 수 있다
    render(){
        const {result, value, tries} = this.state;
        return(
            <>
            <h1>{result}</h1>
            <form onSubmit = {this.onSubmitForm}>
                <input ref = {this.inputRef} maxLength = {4} value = {value} onChange = {onChangeInput}></input>
            </form>
            <div>시도: {tries.length}</div>
            <ul>
                {tries.map((v, i)=>{
                    return(
                        <Try  key={`${i + 1}차 시도 :`} tryInfo={v}></Try>
                    );
                })}
                {/*리액트에서 주석을 입력할 때는 {}로 한번 감싸줘야한다*/}
            </ul>
            </>
        );
    }
}
export default numberBaseball;