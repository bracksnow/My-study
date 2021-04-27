const dotenv = require('dotenv');
dotenv.config()

const express = require('express');
const morgan = require('morgan');
const path = require('path');
const cookieParser = require('cookie-parser');
const session = require('express-session');
const nunjucks = require('nunjucks');

const app = express();
app.set('port', process.env.PORT || 3000);
app.set('view engine', 'html');
nunjucks.configure(__dirname + '/public', {
    autoescape: true,
    express: app,
    watch: true
});



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
const products = {};
app.get('/', (req, res)=>{
    res.redirect('/login')
});
app.get('/login', ((req, res) => {
    res.sendFile(path.join(__dirname, './public/login.html'))
}));
app.get('/admit', ((req, res) => {
    res.send(`id: ${req.query.id}<br> password: ${req.query.password}`);
}));
app.post('/admit', ((req, res) => {
    const {id, password} = req.body;
    if (id ==='ktom97' && password==='1234'){
        res.cookie('admit', true,{
            maxAge: 60000,
            httpOnly:true,
            path:'/',
            signed:true
        });
        res.redirect('/product');
    }else{
        res.redirect('/login');
    }
}));
app.get('/product',(req, res) => {
    res.render(path.join(__dirname, './public/product'), {title: '상품등록서비스'})
});
app.get('/products', (req, res) => {
    res.send(products);
});
app.post('/product', (req, res) => {
    const{name, count, price} = req.body;
    const id = Date.now();
    products[id] = {name, count, price};
    res.end();
});
app.put('/product/:id',(req, res) => {
    const{name, count, price} = req.body;
    products[req.params.id] = {name, count, price};
    res.end();
});
app.delete('/product/:id',(req, res) => {
    delete products[req.params.id];
    res.end();
});
app.use((err, req, res, next) => {
    console.error(err);
    res.status(401).send(err.message);
});
app.listen(app.get('port'), () => {
    console.log(app.get('port'), '번 포트에서 대기 중');
});