package service;

import Repository.MemberRepository;
import Repository.PostRepository;
import Repository.ReplyRepository;
import domain.Member;
import domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private MemberRepository memberRepository;//글 쓸때 사용자 정보가 필요함

    //삭제
    public void deletePost(Post post){
        postRepository.deleteById(post.getId());
    }
    //등록
    @Transactional
    public void writePost(Post post, Member member) { // title, content
        post.setCount(0);
        post.setMember(member);
        postRepository.save(post);
    }
    
    //수정
    public void modiftPost(Long id, Post requestPost) {
        Post post = postRepository.findById(id).orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
                });
        post.setTitle(requestPost.getTitle());
        post.setText(requestPost.getText());
    }

    public Page<Post> watchList(Pageable pageable){
        return postRepository.findAll(pageable);
    }
    @Transactional(readOnly = true)
    public Post detailView(Long id) {
        return postRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패");
                });
    }

    @Transactional
    public void writeReply() {//댓글 작성

    }

    @Transactional
    public void deleteReply(Long replyId) {//댓글 삭제
        replyRepository.deleteById(replyId);
    }

}
