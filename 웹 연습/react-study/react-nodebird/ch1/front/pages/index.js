import React, {useEffect} from 'react';
import {Form, Input, Button, Card, Avatar} from 'antd'
import { HeartOutlined, RetweetOutlined, MessageOutlined, EllipsisOutlined } from '@ant-design/icons';
import PostForm from "../components/PostFrom";
import PostCard from "../components/PostCard";
import {useDispatch, useSelector} from "react-redux";
import {LOG_IN, LOG_OUT} from '../reducers/user';
const Home = () =>{
    const dispatch = useDispatch();
    const {user, isLoggedIn} = useSelector(state=>state.user);
    const {mainPosts} = useSelector(state=>state.post);
    useEffect(()=>{
        dispatch({
            type:LOG_IN,
            data:{
                nickname:'gwon'
            }
        });
        dispatch({
            type:LOG_OUT,
        });
    },[]);//deps에 아무것도 안넣으면 componentdidmount와 같은 의미
    return (
        <div>
            {user ? <div>어서오세요:{user.nickname}</div> : <div>로그아웃 했습니다</div>}
            {isLoggedIn && <PostForm/>}
            {mainPosts.map((c)=>{
                return(
                    <PostCard key = {c} post={c}/>
                );
            })}
        </div>
    );
};

export default Home;