const React = require('react');
const ReactDom = require('react-dom');
const {hot} = require('react-hot-loader/root');
const WordRelay = require('./word_relay');
const Hot = hot(WordRelay);

React.render(<Hot></Hot>, document.querySelector('#root'));