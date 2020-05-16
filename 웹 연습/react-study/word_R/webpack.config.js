const path = require('path');
module.exports = {
    name:'word-relay',
    mode:'development',
    devtool:'eval',
    resolve:{
        extensions:['.js','.jsx']
    },
    //
    entry:{
        app:'./client',
        //현재 이 word_R은 client가 word_relay를 참조받으므로 단순히 client.jsx파일을 app.js파일로 만들면 완성
    },
    //
    module:{
        rules:[{
            test: /\.jsx?$/,
            loader: 'babel-loader',
            options: {
              presets: [
                ['@babel/preset-env', {
                  targets: {browsers: ['last 2 chrome versions']},
                  debug: true,
                }],
                '@babel/preset-react',
              ],
              plugins: ['react-hot-loader/babel'],
            },
            exclude: path.join(__dirname, 'node_modules'),
        }],


    },
    //
    plugin:[],
    //
    output:{
        path:path.join(__dirname, 'dist'),
        filename:'[name].js',
        publicPath:'/dist',
        //여기서 __dirname은 현재 word_R파일의 위치를 말함
    },
    //
};