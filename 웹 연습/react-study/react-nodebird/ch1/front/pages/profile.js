import React from 'react';
import { Form, Button , List , Input, Card} from 'antd';
import { StopOutlined  } from '@ant-design/icons';
import NickNameFrom from "../components/NickNameForm";
const Profile = () =>{
    return (
        <div>
            <NickNameFrom/>
            <List
                style={{marginBottom : '20px'}}
                grid={{gutter : 4, xs : 2, md: 3}}
                size="small"
                header={<div>팔로잉 목록</div>}
                loadMore={<Button style={{width:'100%'}}>더 보기</Button>}
                bordered
                dataSource={['dog','vel','oper']}
                renderItem={item => (
                    <List.Item style={{marginTop: '20px'}}>
                        <Card actions={[<StopOutlined key="stop" type="stop"/>]}><Card.Meta description={item} /></Card>
                    </List.Item>
                )}
            />
            <List
                style={{marginBottom : '20px'}}
                grid={{gutter : 4, xs : 2, md: 3}}
                size="small"
                header={<div>팔로워 목록</div>}
                loadMore={<Button style={{width:'100%'}}>더 보기</Button>}
                bordered
                dataSource={['dog','vel','oper']}
                renderItem={item => (
                    <List.Item style={{marginTop: '20px'}}>
                        <Card actions={[<StopOutlined type="stop"/>]}><Card.Meta description={item} /></Card>
                    </List.Item>
                )}
            />
        </div>
    );
};

export default Profile;