import React from 'react';
import Head from 'next/head';
import PropTypes from 'prop-types';
import AppLayout from '../components/AppLayout';

const NodeBird = ({ Component }) => {
    return (
        <>
            <Head>
                <title>NodeBird</title>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/antd/3.18.1/antd.css" />
                <script src="https://cdnjs.cloudflare.com/ajax/libs/antd/3.18.1/antd.js"></script>
            </Head>
            <AppLayout>
                <Component />
            </AppLayout>
        </>
    );
}
//node는 리액트에 들어갈 수 있는 모든 것을 node라고 표시함
NodeBird.propTypes = {
    Component: PropTypes.elementType.isRequired,
};
export default NodeBird;