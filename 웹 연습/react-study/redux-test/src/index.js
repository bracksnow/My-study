import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
// 추가 부분
import { createStore } from 'redux';
import { Provider  } from 'react-redux'
import counterReducers from './reducers';

const store = createStore(counterReducers);
const appElement = document.getElementById('root');

ReactDOM.render(
  <Provider store = {store}>
    <App />
  </Provider>,
  appElement
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
