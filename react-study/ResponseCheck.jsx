import React, {PureComponent} from 'react';

class ResponseCheck extends PureComponent{
    state = {
        state:'waiting',
        message:'클릭해서 사용하세요',
        result:[],

    }
    timeout;
    startTime;
    endtime;

    onClickScreen = () => {
        const {state, result, message} = this.state;
        if(state==='waiting'){
            this.setState({
                state:'ready',
                message:'초록색이 되면 클릭하세요',

            });
            this.timeout = setTimeout(()=>{
                this.setState({
                    state:'now',
                    message:'지금 클릭',
                });
                this.startTime = new Date();//지연시간이 지난 이후에 setState함수를 실행
            },Math.floor(Math.random()*1000+2000));
        }else if(state==='ready'){//성급하게 누름
            clearTimeout(this.timeout);
            this.setState({
                state:'waiting',
                message:'너무 성급하시군요, 초록색이 된 후 클릭하세요 ',
            });

        }else if(state==='now'){//반응속도 확인
            this.endtime = new Date();
            this.setState((prevState)=>{
                return {
                    state:'waiting',
                    message:'클릭해서 사용하세요',
                    result:[...prevState.result,this.endtime-this.startTime],
                };
            });

        }

    }
    onReset = () => {
        this.setState({
            result:[]
        });
    };

    renderAverage = () =>{
        const {result} = this.state;
        return result.length===0
            ? null
            :<><div>평균시간:{result.reduce((a,c)=>a+c)/result.length}ms</div><button onclick = {this.onReset}></button></>
    };
    render(){
        const {message, state} = this.state;
        return(
            <>
            <div id = 'screen' className =  {state} onClick = {this.onClickScreen}>
            {message}
            </div>
            {this.renderAverage}
            </>
        );
        //jax안에서 for, if문 사용불가능 그래서 반복문의 경우에는 map를 사용
        //리액트에서는 조건문을 삼항연산자를 이용한다
    }
}

export default ResponseCheck;