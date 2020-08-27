export const initialState = {
    mainPosts : [{
        User : {
            id : 1,
            nickname : "Dogveloper",
        },
        content : "첫번째 게시글",
        img : 'https://source.unsplash.com/random',
    }],
    imagePaths:[]
};//초기 state
const ADD_POST = 'ADD_POST';//액션의 이름
const ADD_DUMMY = 'ADD_DUMMY';//액션의 이름

const addPost = {
    type:ADD_POST,
};//액션의 내용

const addDummy = {
    type:ADD_DUMMY,
    data:{
        content:'HI',
        userid:1,
        user:{
            nickname:'gwon'
        }
    },
};

const reducer = (state = initialState, action) => {
    switch (action.type) {
        case ADD_POST:
            return {
                ...state
            };
        case ADD_DUMMY:
            return {
                ...state,
                mainPosts: [action.data, ...state.mainPosts]//action의 data와 state의 mainPosts를 넣어준다는 의미
            };
        default:{
            return{
                ...state
            };
        }
    }
};
export default reducer;