const React = require('react');
const ReactDom = require('react-dom');
const {hot} = require('react-hot-loader/root');
const Baseball = require('./baseball');
const Hot = hot(Baseball);

React.render(<Hot></Hot>, document.querySelector('#root'));