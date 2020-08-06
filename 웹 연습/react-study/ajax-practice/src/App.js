import React, {Component} from 'react';
import './App.css';

class Nav extends Component{
  state = {
    list:[]
  }
  componentDidMount(){
    //list.json을 읽어 result로 출력을 하는데 이것을 다시 json형태로 출력을 하고
    //그 다음에 state로 넣는다
    fetch('list.json').then((result)=>{
      return result.json();
    })
    .then((json)=>{
      console.log(json);
      this.setState(()=>{
        return{
          list:json
        }
      })
    })
  }
  render(){
    var listTag = [];
    for(var i = 0;i<this.state.length;i++){
      var li = this.state.list[i]
    }
    listTag.push(<li key={li.id}><a href={li.id}>{li.title}</a></li>);
    return(
      <nav>
      <ul>
      {listTag}
      </ul>
    </nav>
    );
  }
}

function App() {
  return (
    <div className="App">
     <h1>WEB</h1>
     <Nav></Nav>
      <article>
        <h2>Welcome</h2>
        Hello, React &amp; Ajax
      </article>
    </div>
  );
}

export default App;
