package blog.jpablog.service;


import blog.jpablog.domain.Member;
import blog.jpablog.domain.Post;
import blog.jpablog.dto.ReplyDto;
import blog.jpablog.repository.PostRepository;
import blog.jpablog.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    //@RequiredArgsConstructor로 의존성 주입->@Autowired를 사용해 필드형식을 사용한 것보다 이익이 많음
    //단일책임, 불변성(final)
    private final PostRepository postRepository;
    private final ReplyRepository replyRepository;

    //삭제
    @Transactional
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
    @Transactional
    public void modiftPost(Long id, Post requestPost) {
        Post post = postRepository.findById(id).orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
                });
        post.setTitle(requestPost.getTitle());
        post.setContent(requestPost.getContent());
    }
    //블로그에 올린 글 리스트 보기
    @Transactional(readOnly = true)
    public Page<Post> watchList(Pageable pageable){
        return postRepository.findAll(pageable);
    }

    //상세보기
    @Transactional(readOnly = true)
    public Post detailView(Long id) {
        return postRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패");
                });
    }

    @Transactional
    public void writeReply(ReplyDto replyDto) {//댓글 작성 -> 여러 멤버와 포스트의 데이터를 이용하는 만큼 DTO적용?
        int result = replyRepository.querySave(replyDto.getMemberId(), replyDto.getPostId(), replyDto.getContent());
        System.out.println("BoardService : "+result);

    }

    @Transactional
    public void deleteReply(Long replyId) {//댓글 삭제
        replyRepository.deleteById(replyId);
    }

}
