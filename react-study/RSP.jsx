import React, { Component } from 'react'//만약 성능 최적화를 해야할 경우에는 PureComponent를 사용한다
import { object } from 'prop-types';
//rcc라고 입력하면 플러그인이 어느정도 알아서 만들어줌
// 클래스의 경우 -> constructor -> render -> ref -> componentDidMount
// (setState/props 바뀔때) -> shouldComponentUpdate(true) -> render -> componentDidUpdate
// 부모가 나를 없앴을 때 -> componentWillUnmount -> 소멸
const rspCoords = {
    바위: '0',
    가위: '-142px',
    보: '-284px',
  };
  
  const scores = {
    가위: 1,
    바위: 0,
    보: -1,
  };
const computerChoice = (imgCoord) =>{
  return object.entries(rspCoords).find(function(v){
    return v[1]===imgCoord;
  })[0];
}

class RSP extends Component {
    state = {
        result: '',
        imgCoord: rspCoords.바위,
        score: 0,
      };
      interval;
      componentDidMount(){//처음에 RSP라는 컴포넌트가 만들어지고 render가 처음 실행될 때를 말한다, 여기에 비동기 요청을 한다
        this.interval = setInterval(() => {//이부분을 정리하지 않으면 컴포넌트가 끝나도 계속 돌아감->정리하는 작업이 필수
          const {imgCoord} = this.state;//비동기방식에서 변수를 밖에 생성하는 경우엔 클로저 문제가 생긴다.
          if(imgCoord===rspCoords.바위){
            this.setState({
              imgCoord:rspCoords.가위,
            });
          }else if(imgCoord===rspCoords.가위){
            this.setState({
              imgCoord:rspCoords.보
            });
          }else if(imgCoord===rspCoords.보){
            this.setState({
              imgCoord:rspCoords.주먹
            });
          }
        }, 1000);
        //this.interval = setInterval(changeHand,1000)로 변경가능
      }
      
      componentWillUnmount(){//컴포넌트가 제거되기 직전, 비동기요청 정리작업을 한다
        clearInterval(this.interval);
      };
      componentDidUpdate(){//리랜더링 후 

      };
      changeHand = () =>{
        const {imgCoord} = this.state;//비동기방식에서 변수를 밖에 생성하는 경우엔 클로저 문제가 생긴다.
        if(imgCoord===rspCoords.바위){
          this.setState({
            imgCoord:rspCoords.가위,
          });
        }else if(imgCoord===rspCoords.가위){
          this.setState({
            imgCoord:rspCoords.보
          });
        }else if(imgCoord===rspCoords.보){
          this.setState({
            imgCoord:rspCoords.주먹
          });
        }
      };

      onClickBtn = (choice) =>()=>{
        const {imgCoord} = this.state;
        clearInterval(this.interval);
        const myScore = scores[choice];//choice가 scores객체의 키의 역할을 한다
        const cpuScore  =scores[computerChoice(imgCoord)];
        const diff = myScore-cpuScore;
        if(diff===0){
          this.setState({
            result:'비겼습니다',
          });
        }else if([-1,2].includes(diff)){
          this.setState((prevState)=>{
            return{
              result:'이겼습니다',
              score:prevState.score+1,
            };

          });
        }else{
          this.setState((prevState)=>{
            return{
              result:'졌습니다',
              score:prevState.score-1,
            };

          });
        }setTimeout(() => {
          this.interval = setinterval(this.changeHand,1000);//결과를 확인하기 위해 2초 뒤에 돌아가도록 설정
        }, 2000);
      };
    render() {
        const { result, score, imgCoord } = this.state;
        return (
            <>
            <div id="computer" style={{ background: `url(https://en.pimg.jp/023/182/267/1/23182267.jpg) ${imgCoord} 0` }} />
            <div>
              <button id="rock" className="btn" onClick={this.onClickBtn('바위')}>바위</button>
              <button id="scissor" className="btn" onClick={this.onClickBtn('가위')}>가위</button>
              <button id="paper" className="btn" onClick={this.onClickBtn('보')}>보</button>
            </div>
            <div>{result}</div>
            <div>현재 {score}점</div>
          </>
        );
    }
}
export default RSP;
