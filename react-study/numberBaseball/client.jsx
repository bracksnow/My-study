import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
import numberBaseball from './numberbaseball';
const Hot = hot(numberBaseball);
ReactDOM.render(<Hot></Hot>, document.querySelector('#root'));