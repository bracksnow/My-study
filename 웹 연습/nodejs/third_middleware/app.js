const dotenv = require('dotenv');
dotenv.config()

const express = require('express');
const morgan = require('morgan');
const path = require('path');
const cookieParser = require('cookie-parser');
const session = require('express-session');

const app = express();
app.set('port', process.env.PORT || 3000);
app.use(morgan('dev'));
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.json());
app.use(express.urlencoded({extended:false}));
app.use(cookieParser(process.env.COOKIE_SECRET));//환경변수에 쿠키 시크릿으로 저장한 것임
app.use(session({
    resave:false,
    saveUninitialized:false,
    secret:'mysign',
    cookie:{
        httpOnly:true,
        secure:false,
        maxAge:50000000
    }, name:'session-cookie'
}));
const users = {};
app.use((req,res,next)=>{
    console.log(req.session);
    console.log(req.sessionID);
    req.session.views = (req.session.views || 0)+1;
    next();
});
    app.get('/', (req, res)=>{
    if(req.signedCookies.admit){
        res.send('<h1>Login Success</h1>');
    }
    else{
        res.redirect('/login')
    }
})
app.get('/login', ((req, res) => {
    res.sendFile(path.join(__dirname, './public/login.html'))
}));
app.get('/admit', ((req, res) => {
    console.log(req.query);
    console.log(req.body)
    res.send(`username: ${req.query.login}<br> password: ${req.query.password}`);
}));
app.post('/admit', ((req, res) => {
    const {login, password} = req.body;
    console.log(req.query);
    if (login == 'guest' && password=='7777'){
        res.cookie('admit', true,{
            maxAge: 60000,
            httpOnly:true,
            path:'/',
            signed:true
        });
        res.redirect('/');
    }else{
        res.redirect('/login');
    }
}));
app.get('/user', (req, res) => {
    res.sendFile(path.join(__dirname, './public/user.html'))
});
app.get('/users', (req, res) => {
    res.send(users)
});
app.post('/user', (req, res) => {
    const{name, memo} = req.body;
    const id = Date.now();
    users[id] = {name, memo};
    res.end();
});
app.put('/user/:id',(req, res) => {
    const{name, memo} = req.body;
    users[req.params.id] = {name, memo};
    res.end();
});
app.delete('/user/:id',(req, res) => {
    delete users[req.params.id];
    res.end();
});
app.use((err, req, res, next) => {
    console.error(err);
    res.status(401).send(err.message);
});
app.listen(app.get('port'), () => {
    console.log(app.get('port'), '번 포트에서 대기 중');
});