const React = require('react');
const {Component} = react;
const WordRelay = () => {
    const [word, setword] = useState('kwon');
    const [value, setvalue] = useState('');
    const [result, setresult] = useState('');
    const Inputref = useRef(null);

    const onSubmitForm = () =>{
        e.preventDefault();
        if(word[word.length-1]===value[0]){
            setresult('딩동댕');
            setword(value);
            setvalue('');
            Inputref.current.focus();
        }else{
            setresult('땡');
            setvalue('');
            Inputref.current.focus();
        }

    }
    return(
        <>
        <div>{word}</div>
        <form onSubmit={onSubmitForm}>
          <input
            ref={Inputref}
            value={value}
            onChange={(e) => setvalue(e.currentTarget.value)}
          />
          <button>입력!</button>
        </form>
        <div>{result}</div>
      </>
    );

}
module.exports = WordRelay;