const http = require('http');
const fs = require('fs').promises;

const products = []; // 상품객체들을 저장할 배열

http.createServer(async (req, res) => {
    try {
        if (req.method === 'GET') {//http메서드가 get인 경우
            if (req.url === '/') {
                const data = await fs.readFile('./about.html');
                res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
                return res.end(data);
            } else if (req.url === '/regist') {
                const data = await fs.readFile('./regist.html');
                res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
                return res.end(data);
            } else if (req.url === '/products') {
                res.writeHead(201, { 'Content-Type': 'application/json; charset=utf-8' });
                return res.end(JSON.stringify(products));
            }
            try {
                const data = await fs.readFile(`.${req.url}`);
                console.log(req.url)
                return res.end(data);
            } catch (err) {
            }
        } else if (req.method === 'POST') {//http메서드가 post인 경우
            if (req.url === '/product') {
                let body = '';
                // 요청의 body를 stream 형식으로 받음
                req.on('data', (data) => {
                    body += data;
                });
                // 요청의 body를 다 받은 후 실행됨
                return req.on('end', () => {
                    const { product, price, count, image } = JSON.parse(body);
                    const pd = new Object();//상품을 객체로 만듦
                    pd.product = product;
                    pd.price = price;
                    pd.count = count;
                    pd.image = image;
                    products.push(pd);//상품객체를 products 배열에 넣어줌
                    res.writeHead(201, { 'Content-Type': 'text/plain; charset=utf-8' });
                    res.end('ok');
                });
            }
        }
        res.writeHead(404);
        return res.end('NOT FOUND');
    } catch (err) {
        console.error(err);
        res.writeHead(500, { 'Content-Type': 'text/plain; charset=utf-8' });
        res.end(err.message);
    }
})
    .listen(8080, () => {
        console.log('8080번 포트에서 서버 대기 중입니다');
    });