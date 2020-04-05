import React, {useEffect,useState,useRef, useCallback} from 'react'
import Ball from './Ball';
function getWinNumbers() {
    console.log('getWinNumbers');
    const candidate = Array(45).fill().map((v, i) => i + 1);
    const shuffle = [];
    while (candidate.length > 0) {
      shuffle.push(candidate.splice(Math.floor(Math.random() * candidate.length), 1)[0]);
      const bonusNumber = shuffle[shuffle.length - 1];
      const winNumbers = shuffle.slice(0, 6).sort((p, c) => p - c);
      return [...winNumbers, bonusNumber];
    }
}
const Lotto = () =>{
    const lottoNumbers = useMemo(() => getWinNumbers(), []);//hooks는 함수형 컴포넌트라 전체를 재실행하는데 이것을 막아주기 위해서는 usememo를 사용해서 2번째인자가 바뀌는 경우만 재실행하도록 한다
    const [winNumbers, setwinNumbers] = useState(lottoNumbers);
    const [winBalls, setwinBalls] = useState([]);
    const [bonus, setbonus] = useState(null);
    const [redo, setredo] = useState(false);
    const timeouts = useRef([]);
    useEffect(() => {
        console.log('useEffect');
        for (let i = 0; i < winNumbers.length - 1; i++) {
          timeouts.current[i] = setTimeout(() => {
            setWinBalls((prevBalls) => [...prevBalls, winNumbers[i]]);
          }, (i + 1) * 1000);
        }
        timeouts.current[6] = setTimeout(() => {
          setBonus(winNumbers[6]);
          setRedo(true);
        }, 7000);
        return () => {
            timeouts.current.forEach((v) => {
                clearTimeout(v);
            });
        }
    }, [timeouts.current]);
    const onClickRedo = useCallback(() => {//usevallback을 써서 함수를 기억하도록 하며 여기서 state에 있는 값을 사용하는 경우에는 2번째 인자에 넣어서 보호한다
        console.log('onClickRedo');
        console.log(winNumbers);
        setwinNumbers(getWinNumbers());
        setwinBalls([]);
        setbonus(null);
        setredo(false);
        timeouts.current = [];
      }, [winNumbers]);
    
    return(
        <>
        <div>당첨 숫자</div>
        <div id="결과창">
          {winBalls.map((v) => <Ball key={v} number={v} />)}
        </div>
        <div>보너스!</div>
        {bonus && <Ball number={bonus} onClick={onClickRedo} />}
        {redo && <button onClick={onClickRedo}>한 번 더!</button>}
        </>
    );
}
export default Lotto;