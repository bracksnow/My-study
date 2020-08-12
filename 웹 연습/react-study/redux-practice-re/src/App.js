import React, {Component} from 'react';
import AddNumberRoot from "./components/AddNumberRoot.jsx";
import DisplayNumberRoot from "./components/DisplayNumberRoot";
import './App.css';

class App extends Component{
  render(){
  return (
    <>
      <h1>Root</h1>
      <AddNumberRoot></AddNumberRoot>
      <DisplayNumberRoot></DisplayNumberRoot>
    </>
  );
  }
}

export default App;
