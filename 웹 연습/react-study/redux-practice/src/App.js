import React, {Component, useState} from 'react';
import './App.css';
import AppNumberRoot from './components/AppNumberRoot'
import DisplayNumberRoot from './components/DisplayNumberRoot.jsx'

const App = () =>{
  const [number, setNumber] = useState(0);
  return (
    <div className = 'App'>
      <h1>Root</h1>
      <AppNumberRoot onClick = {(size)=>{
        setNumber(number+size);
      }}></AppNumberRoot>
      <DisplayNumberRoot number = {number}></DisplayNumberRoot>
    </div>
  );
  //함수를 호출하는 것으로 부모 컴포넌트에 값을 넘겨준다
}





export default App;
