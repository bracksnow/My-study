import React from 'react';
import './App.css';
import Counter from "./component/counter"
import CounterLower from "./component/counterlower"
import CounterUpper from "./component/counterupper"

function App() {
  return (
    <div className="App">
      <Counter/>
      <CounterLower name = "A"/>
      <CounterUpper name = "B"/>
    </div>
  );
}

export default App;
