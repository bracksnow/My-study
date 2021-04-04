async function getProduct() { // 로딩 시 상품 가져오는 함수
    try {
        const res = await axios.get('/products');
        const products = res.data;
        const list = document.getElementById('list');
        list.innerHTML = '';
        products.map((product,i)=>{//products에서 product객체를 가져온다
            const productDiv = document.createElement('div');
            Object.values(product).map(function (value,index) {//product의 속성마다 span이나 img태그를 만듦
                const span = document.createElement("span");
                const image = document.createElement('img');
                if(index===3){
                    image.src = value
                    //alert("보안상 이미지는 출력이 안됩니다!!") 이미지 출력까지 시도했지만 AWS까지 넘어가 파일유뮤만 확인가능
                }else{
                    span.textContent = value+" ";//product객체의 속성들을 전부 span태그안으로
                }
                productDiv.appendChild(span);
                productDiv.appendChild(image);
                list.appendChild(productDiv);//list에 product객체를 담아 웹으로 보여줌
            })
        });
    } catch (err) {
        console.error(err);
    }
}

window.onload = getProduct; // 화면 로딩 시 getProduct 호출
document.getElementById('form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const product = document.getElementById("product").value;//form태그에 입력된 값을 가져온다
    const price = document.getElementById("price").value;
    const count = document.getElementById("count").value;
    const image = document.getElementById("image").value;
    if (!product) {
        return alert('상품을 입력하세요');
    }
    else if (!price) {
        return alert('가격을 입력하세요');
    }
    else if (!count) {
        return alert('수량을 입력하세요');
    }
    try {
        await axios.post('/product', { product, price, count, image });//axios로 객체형태로 ajax사용
        getProduct();
    } catch (err) {
        console.error(err);
    }
});