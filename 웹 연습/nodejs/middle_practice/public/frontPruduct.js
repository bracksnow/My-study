async function getProduct() {
    try {
        const res = await axios.get('/products');
        const products = res.data;

        const list = document.getElementById('list');
        list.innerHTML = '';
        Object.keys(products).map(function (key) {
            const productDiv = document.createElement('div');
            const span = document.createElement('span');
            span.textContent = products[key].name+'의 수량은 '+products[key].count+'개'+'이며 1개당 가격은 '+products[key].price+'원입니다. 총 가격:'+parseInt(products[key].count)*parseInt(products[key].price)+'원입니다.';
            const edit = document.createElement('button');
            edit.textContent = '수정';
            edit.addEventListener('click', async () => { // 수정 버튼 클릭
                const name = prompt('바꿀 상품명을 입력하세요');
                const count = prompt('수량을 입력하세요');
                const price = prompt('가격을 입력하세요');

                if (!name||!count||!price) {
                    return alert('상품명, 수량, 가격을 꼭 입력하세요');
                }
                try {
                    await axios.put('/product/' + key, { name, count, price });
                    getProduct();
                } catch (err) {
                    console.error(err);
                }
            });
            const remove = document.createElement('button');
            remove.textContent = '삭제';
            remove.addEventListener('click', async () => { // 삭제 버튼 클릭
                try {
                    await axios.delete('/product/' + key);
                    getProduct();
                } catch (err) {
                    console.error(err);
                }
            });
            productDiv.appendChild(span);
            productDiv.appendChild(edit);
            productDiv.appendChild(remove);
            list.appendChild(productDiv);
            console.log(res.data);
        });
    } catch (err) {
        console.error(err);
    }
}

window.onload = getProduct;
// 폼 제출(submit) 시 실행
document.getElementById('form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = e.target.name.value;
    const count = e.target.count.value;
    const price = e.target.price.value;

    if (!name||!count||!price) {
        return alert('상품명, 수량, 가격을 꼭 입력하세요');
    }
    try {
        await axios.post('/product', { name, count, price });
        console.log(name);
        console.log(count);
        console.log(price)
        getProduct();
    } catch (err) {
        console.error(err);
    }
    e.target.name.value = '';
    e.target.count.value = '';
    e.target.price.value = '';
});