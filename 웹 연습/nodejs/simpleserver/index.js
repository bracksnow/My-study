//상품등록서버만들기
const http = require('http');
const fs = require('fs').promises;
const products = [];//상품 구성:제품이름, 수량, 가격
let id = 0;

http.createServer(async (req, res) => {
    try {
        if (req.method === 'GET'){
            if (req.url === '/'){
                const data = await fs.readFile("./productList.html");
                res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
                if (products.length!==0){
                    res.write(data)
                    return res.end(JSON.stringify(products));
                }else{
                    return res.end(data)
                }
            }else if (req.url === '/registrations'){
                const data = await fs.readFile('./productRegistration.html');
                res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
                return res.end(data);
            }else{
                try{
                    const data = await fs.readFile(`.${req.url}`);//"/"나 "registration이 아닌 경우"
                    return res.end(data);
                }catch(error){//사용자가 원하는 url을 띄워주고 원하는 페이지가 없는 경우 에러 출력
                    res.end(error.message);
                }
            }
        }else if (req.method === 'POST'){//상품등록
            console.log('ehdwkrgka')
            if(req.url==='/registrations'){
                let body = '';
                req.on('data', (data)=>{//data가 들어오는 경우
                    body+=data;
                });
                return req.on('end',()=>{//data가 전부 들어온 경우
                    console.log(body)
                    let product = new Object();
                    product.id = id;
                    product.detail = body
                    products[id] = product
                    id++;
                    res.writeHead(201)
                    res.end("등록 성공")
                });
            }
        }/*else if (req.method === 'PUT'){//상품수정
            if (req.url.startsWith('/registration/')) {
                const id = req.url.split('/')[2];
                let body = '';
                req.on('data', (data) => {
                    body += data;
                });
                return req.on('end', () => {
                    products[id] = JSON.parse(body).detail;
                    res.writeHead(200, { 'Content-Type': 'text/plain; charset=utf-8' });
                    return res.end('ok');
                });
            }

        }*/
        /*else if (req.method === 'DELETE'){//상품삭제
            if (req.url.startsWith('/registration/')) {
                const id = req.url.split('/')[2];
                delete products[id]
                res.writeHead(200, {'Content-Type': 'text/plain; charset=utf-8'});
                return res.end('ok');
            }
        }*/
    } catch (err) {//HTTP메서드가 아닌 다른 것이 날라올 경우 에러 출력
        console.error(err);
        res.writeHead(500, { 'Content-Type': 'text/plain; charset=utf-8' });
        res.end(err.message);
    }
})
    .listen(8080, () => {
        console.log('8080번 포트에서 서버 대기 중입니다!');
    });