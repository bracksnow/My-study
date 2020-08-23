import React from 'react';
import {Avatar, Button, Card} from "antd";
import PropTypes from 'prop-types';
import {EllipsisOutlined, HeartOutlined, MessageOutlined, RetweetOutlined} from "@ant-design/icons";

const PostCard = ({post}) =>{
    return(
        <Card
            key={+post.createdAt}
            /*날짜를 의미하는 연산자임->주석처리?*/
            cover={post.img && <img alt="example" src={post.img} />}
            actions = {[
                <RetweetOutlined key="message"/>,
                <HeartOutlined key = "heart" />,
                <MessageOutlined key="message" />,
                <EllipsisOutlined key="ellipsis" />,
            ]}
            extra={<Button>팔로우</Button>}
        >
            <Card.Meta
                avatar={<Avatar>{post.User.nickname[0]}</Avatar>}
                title={post.User.nickname}
                description={post.content}
            />
        </Card>

    );
};


PostCard.propTypes = {
    post : PropTypes.shape({
        User : PropTypes.object,
        content : PropTypes.string,
        img: PropTypes.string,
        createdAt:PropTypes.object,
    }),
};
export default PostCard;