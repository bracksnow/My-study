package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Getter @Setter
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    
    private String title;//주제

    private String text;//본문 텍스트

    private LocalDateTime postDate;//블로그에 글을 올린 시간

    /*
    * 연관관계 메서드
    * */
    public void setMember(Member member){
        this.member = member;
        member.getPosts().add(this);
    }
}
