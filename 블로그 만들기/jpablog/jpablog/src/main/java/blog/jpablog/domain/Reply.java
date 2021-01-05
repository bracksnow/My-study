package blog.jpablog.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)//포스트 하나당 댓글은 여러개
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp createDate;//생성날짜 - 자동입력됨

    @Override
    public String toString() {
        return "Reply [id=" + id + ", content=" + content + ", board=" + post + ", member=" + member + ", createDate="
                + createDate + "]";
    }
}