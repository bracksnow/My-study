
async function getUser() {
    try {
        const res = await axios.get('/users');
        const users = res.data;
        const list = document.getElementById('list');
        list.innerHTML = '';
        Object.keys(users).map(function (key) {
            const userDiv = document.createElement('div');
            const span = document.createElement('span');
            span.textContent = users[key];
            userDiv.appendChild(span);
            list.appendChild(userDiv);
            console.log(res.data);
        });
    } catch (err) {
        console.error(err);
    }
}

window.onload = getUser;
document.getElementById('form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = e.target.username.value;
    if (!name) {
        return alert('이름을 입력하세요');
    }
    try {
        await axios.post('/user', { name });
        getUser();
    } catch (err) {
        console.error(err);
    }
    e.target.username.value = '';
});