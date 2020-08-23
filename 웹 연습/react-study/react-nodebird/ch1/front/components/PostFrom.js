import React from 'react';
import {Button, Form, Input} from "antd";

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

const PostForm  = () =>{
    return(
        <Form style = {{margin:'10px, 0, 20px' }} encType = "multipart/form-data">
            <Input.TextArea maxLength = {150} placeholder = "어떤 일이 있었나요?"/>
            <div>
                <Input type = "file" multiple hidden></Input>
                <Button>이미지 업로드</Button>
                <Button type = "primary" style = {{float:"right"}} htmlType = "submit">제출</Button>
            </div>
            <div>
                {dummy.imagePaths.map((v,i)=>{
                    return(
                        <div key={v} style={{display:'inline-block'}}>
                            <img src={'http://localhost:3065/'+v} style = {{width:'200px'}} alt = {v}/>
                            <div>
                                <Button>제거</Button>
                            </div>
                        </div>
                    );
                })}
            </div>
        </Form>
    );
}
export default PostForm;