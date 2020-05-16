import React, {useState, useRef, useEffect} from 'react';

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
  return Object.entries(rspCoords).find(function(v){
    return v[1]===imgCoord;
  })[0];
}


const RSP = () =>{
    const [result, setResult] = useState('');
    const [imgCoord, setImgcoord] = useState(rspCoords.바위);
    const [score, setScore] = useState(0);
    const interval = useRef();

    useEffect(() => {
        interval.current = setInterval(changeHand,1000);//componentWillUnmount, componentDidmount
        return () => {//hooks는 매번 코드 전체가 다시 실행된다
            //그러다보니 component는 경우에 따라 관리가 가능하지만 hooks의 경우에는 useEffect전체가 돌아간다
            clearInterval(interval.current);//componentDidUpdate
        }
    }, [imgCoord])//빈칸일 경우에는 아예 처음 한번만 사용하고 안에 들어간 것이 있는 경우엔 배열안에 있는 것이 바뀔때 마다 돌아간다

    const changeHand = () =>{
        if(imgCoord===rspCoords.바위){
          setImgcoord(rspCoords.가위);
        }else if(imgCoord===rspCoords.가위){
            setImgcoord(imgCoord.보);
        }else if(imgCoord===rspCoords.보){
            setImgcoord(imgCoord.주먹);
        }
      };

    const onClickBtn = (choice) =>()=>{
        clearInterval(interval.current);
        const myScore = scores[choice];//choice가 scores객체의 키의 역할을 한다
        const cpuScore  =scores[computerChoice(imgCoord)];
        const diff = myScore-cpuScore;
        if(diff===0){
            setResult('비겼습니다')
        }else if([-1,2].includes(diff)){
          this.setState((prevState)=>{
            setResult('이겼습니다');
            setScore(prevState.score+1);
          });
        }else{
          this.setState((prevState)=>{
              setResult('졌습니다');
              setScore(prevState.score-1);

          });
        }setTimeout(() => {
            interval = setinterval(changeHand,1000);//결과를 확인하기 위해 2초 뒤에 돌아가도록 설정
        }, 2000);
      };
      return(
        <>
        <div id="computer" style={{ background: `url(https://en.pimg.jp/023/182/267/1/23182267.jpg) ${imgCoord} 0` }} />
        <div>
          <button id="rock" className="btn" onClick={onClickBtn('바위')}>바위</button>
          <button id="scissor" className="btn" onClick={onClickBtn('가위')}>가위</button>
          <button id="paper" className="btn" onClick={onClickBtn('보')}>보</button>
        </div>
        <div>{result}</div>
        <div>현재 {score}점</div>
      </>
      );
}
export default RSP;