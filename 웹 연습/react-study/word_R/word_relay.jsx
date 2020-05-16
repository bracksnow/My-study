const React = require('react');
const {Compenent} = React;//원래 Component를 사용할 때 React.Component라고 사용하는 것을 Component라고 사용
class WordRelay extends Compenent{
    state = {
        word:'kwon',
        value:'',
        result:'',
    }
    onSubmitForm = (e) =>{
        e.preventDefault();
        if(this.state.word[this.state.word.length-1]===this.state.value[0]){
            this.setState({
                result:'정답!',
                word: value,
                value: ''
            });
            this.input.focus();
        }else{
            this.setState({
                result:'오답',
                value:''
            });
            this.input.focus();

        }

    }
    onChangeInput = (e) =>{
        this.setState({
            value:e.target.value
        });

    }
    input;
    onRefInput = (c) =>{
        this.input = c;

    }

    render(){
        return(
            <>
             <div>{this.state.word}</div>
            <form onSubmit = {this.onSubmitForm}>
                <input ref = {this.onRefInput} value = {this.state.value} onChange = {this.onChangeInput}></input>
                <button>버튼</button>
            </form>
            <div>{this.state.value}</div>
            </>

        );
    }
}
module.exports = WordRelay;