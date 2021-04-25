async function getUser() { // 로딩 시 사용자 가져오는 함수
    try {
        const res = await axios.get('/users');
        const users = res.data;

        const list = document.getElementById('list');
        list.innerHTML = '';
        Object.keys(users).map(function (key) {
            const userDiv = document.createElement('div');
            const span = document.createElement('span');
            span.textContent = users[key].name+'님의 글: '+users[key].memo;
            const edit = document.createElement('button');
            edit.textContent = '수정';
            edit.addEventListener('click', async () => { // 수정 버튼 클릭
                const name = prompt('바꿀 이름을 입력하세요');
                const memo = prompt('수정할 글을 입력하세요');

                if (!name||!memo) {
                    return alert('이름과 글을 반드시 입력하셔야 합니다');
                }
                try {
                    await axios.put('/user/' + key, { name, memo });
                    getUser();
                } catch (err) {
                    console.error(err);
                }
            });
            const remove = document.createElement('button');
            remove.textContent = '삭제';
            remove.addEventListener('click', async () => { // 삭제 버튼 클릭
                try {
                    await axios.delete('/user/' + key);
                    getUser();
                } catch (err) {
                    console.error(err);
                }
            });
            userDiv.appendChild(span);
            userDiv.appendChild(edit);
            userDiv.appendChild(remove);
            list.appendChild(userDiv);
            console.log(res.data);
        });
    } catch (err) {
        console.error(err);
    }
}

window.onload = getUser; // 화면 로딩 시 getUser 호출
// 폼 제출(submit) 시 실행
document.getElementById('form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const name = e.target.name.value;
    const memo = e.target.memo.value;

    if (!name||!memo) {
        return alert('이름과 글을 입력하세요');
    }
    try {
        await axios.post('/user', { name, memo });
        console.log(name);
        console.log(memo)
        getUser();
    } catch (err) {
        console.error(err);
    }
    e.target.name.value = '';
    e.target.memo.value = '';
});