//import와 require는 문법상 차이가 있을 뿐 용도는 같다
import React, {Component} from 'react';
import Try from './Try';
function getNumbers(){//숫자 4개를 겹치지 않게 뽑는 함수
    const candidate = [1,2,3,4,5,6,7,8,9];
    const array = [];
    for(let i = 0;i<candidate.length;i++){
        const chosen = candidate.splice(Math.floor(Math.random()*(9-i)),1)[0];
        array.push(chosen);
    }
    return array;

}

class Baseball extends Component{
    state = {
        result:'',
        value:'',
        answer:getNumbers(),
        tries:[]

    }
    //리액트에서는 일반적으로 함수를 만들 경우에는 화살표함수를 사용
    onSubmitForm = (e) => {
        const { value, tries, answer } = this.state;
        e.preventDefault();
        if (value === answer.join('')) {
          this.setState((prevState) => {
            return {
              result: '홈런!',
              tries: [...prevState.tries, { try: value, result: '홈런!' }],
                //리액트는 참조한 것이 달라졌을 경우에 render()가 돌아가기 때문에 이 경우에는 .push()함수는 사용이 불가능하다
                //그래서 tries배열이 옛날 것을 넣어주고 거기에 새로운 것을 또 넣어주는 방식으로 한다
            }
          });
          alert('게임을 다시 시작합니다!');
          this.setState({
            value: '',
            answer: getNumbers(),
            tries: [],
          });
          this.inputRef.current.focus();
        } else { // 답 틀렸으면
          const answerArray = value.split('').map((v) => parseInt(v));
          let strike = 0;
          let ball = 0;
          if (tries.length >= 9) { // 10번 이상 틀렸을 때
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
            this.setState((prevState) => {
              return {
                tries: [...prevState.tries, { try: value, result: `${strike} 스트라이크, ${ball} 볼입니다`}],
                value: '',
              };
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
    
    input;
    fruits = [
        {fruit:'사과',taste:'맛있다'},
        {fruit:'바나나',taste:'맛있다'}
    ];

    render(){
        return(
            <>
            <h1>{this.state.result}</h1>
            <form onSubmit = {this.onSubmitForm}>
                <input maxLength = {4} value = {this.state.value} onChange = {this.onChangeInput}>

                </input>
            </form>
            <div>시도: {this.state.tries.length}</div>
            <ul>
                {this.state.tries.map((v, i)=>{
                    return(
                        <Try key={`${i + 1}차 시도 :`} tryInfo={v}></Try>
                    );
                })}
            </ul>
            </>
        );
    }

}
//여기서 반복문에 key를 넣는 것은 반복문의 인덱스와 같은 것을 넣어 구분한다는 것이다->단순히 i로 숫자를 받는 것은 가장 안 좋음, key로 컴포넌트를 구분
export default Baseball;//require를 사용할 때는 module.exports = baseball;
//export할 때 default를 사용한 경우에는 {}와 같은 구조분해를 사용하지 않지만 (1번만 사용가능)
//export const hello = 'hello';의 경우에는 나중에 import {hello}와 같은 구조분해를 사용해줘야한다(변수명만 겹치지 않으면 여러번 사용가능)
//엄밀히 module.exports와 export default는 다르지만 호환은 가능
//노드에서는 require와 module.exports를 사용하고 리액트에서는 inport와 export default를 사용