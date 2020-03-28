import React, {useState} from 'react';
const ResponseCheck = () =>{
    const [state, setstate] = useState('waiting');
    const [message, setmessage] = useState('클릭해서 사용하세요');
    const [result, setresult] = useState([]);
    const onReset= () =>{
        setresult();
    };
    const timeout = useRef(null);
    const startTime =useRef();
    const endtime = useRef();//값은 입력은 받지만 render를 하고 싶지 않은 경우에는 밖으로 빼서 만든다
    //hooks에선 useRef를 사용한다
    const onClickScreen = () =>{
        if(state==='waiting'){
            setstate('ready');
            setmessage('초록색이 되면 클릭하세요');
            timeout.current = setTimeout(()=>{
                setmessage('지금 클릭');
                setstate('now');
                startTime.current = new Date();//지연시간이 지난 이후에 setState함수를 실행
            },Math.floor(Math.random()*1000+2000));
        }else if(state==='ready'){//성급하게 누름
            clearTimeout(timeout.current);
            setstate('waiting');
            setmessage('너무 성급하시군요, 초록색이 된 후 클릭하세요');
        }else if(state==='now'){//반응속도 확인
            endtime.current = new Date();
            setstate('waiting');
            setmessage('클릭해서 사용하세요');
            setresult((prevState)=>{
                return
                    result:[...prevState.result,endtime.current-startTime.current];
                
            });
        }
    };
    const renderAverage = () =>{
        return result===0
        ?null
        :<><div>평균시간:{result.reduce((a,c)=>a+c)/result.length}ms</div><button onclick = {onReset}></button></>

    }

    return(
        <>
        <div id = 'screen' className =  {state} onClick = {onClickScreen}>
        {message}
        </div>
        {renderAverage}
        </>
    );
}
export default ResponseCheck;