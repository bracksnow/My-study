import React from 'react';
import Head from 'next/head';
import PropTypes from 'prop-types';
import AppLayout from '../components/AppLayout';
import withRedux from 'next-redux-wrapper';
import reducer from '../reducers';//index.js를 의미함->생략
import {Provider} from 'react-redux';
import {createStore, compose, applyMiddleware} from "redux";
//provider가 redux의 state를 제공함


const NodeBird = ({ Component, store }) => {
    return (
        <Provider store = {store}>
            <Head>
                <title>NodeBird</title>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/antd/3.18.1/antd.css" />
                <script src="https://cdnjs.cloudflare.com/ajax/libs/antd/3.18.1/antd.js"></script>
            </Head>
            <AppLayout>
                <Component />
            </AppLayout>
        </Provider>
    );
}
//node는 리액트에 들어갈 수 있는 모든 것을 node라고 표시함
NodeBird.propTypes = {
    Component: PropTypes.elementType.isRequired,
    store:PropTypes.object
};
export default withRedux((initialState, options)=>{//_app에 store를 넣어주는 역할, initialState는 redux에서 state를 넣어줌
    const middlewares = [];
    const enhancer = compose(applyMiddleware(...middlewares),
        !options.isServer && window.__REDUX_DEVTOOLS_EXTENSION__ !=='undefined' ? window.__REDUX_DEVTOOLS_EXTENSION__() :(f)=>f,);//미들웨어끼리 합쳐주는 compose
    //미들웨어는 액션과 스토어 사이에서 동작
    const store = createStore(reducer, initialState, enhancer);
    return store;
})(NodeBird);