import React from 'react';
import {Form, Input, Button, Card, Avatar} from 'antd'
import { HeartOutlined, RetweetOutlined, MessageOutlined, EllipsisOutlined } from '@ant-design/icons';
import PostForm from "../components/PostFrom";
import PostCard from "../components/PostCard";

const dummy = {
    isLoggedIn : true,
    imagePaths: [],
    mainPosts : [{
        User : {
            id : 1,
            nickname : "Dogveloper",
        },
        content : "첫번째 게시글",
        img : 'https://source.unsplash.com/random',
    }],
};

const Home = () =>{
    return (
        <div>
            {dummy.isLoggedIn && <PostForm/>}
            {dummy.mainPosts.map((c)=>{
                return(
                    <PostCard key = {c} post={c}/>
                );
            })}
        </div>
    );
};

export default Home;