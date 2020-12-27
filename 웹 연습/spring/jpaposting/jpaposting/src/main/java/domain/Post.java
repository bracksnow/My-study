package domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor//생성자를 자동으로 생성하는 것(이 경우에는 파라미터 필요X)
@AllArgsConstructor//파라미터가 모두 있어야하는 생성자를 생성하는 것
@Builder
public class Post {

    @Id @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)//왠만하면 지연로딩 사용하기 ->N+1문제 발생
    @JoinColumn(name = "member_id")//FK값을 의미함
    private Member member;

    @Column(nullable = false, length = 100)
    private String title;//주제

    @Lob//대용량 데이터를 의미
    private String text;//본문 텍스트

    @CreationTimestamp
    private Timestamp createDate;//생성날짜 - 자동입력됨

    @ColumnDefault("0")
    private int count;//조회수를 의미

    @OneToMany(mappedBy = "post")//DB에 저장하지 않아야한다는 의미임 DB에 칼럼을 만들지 말라는 것과 동일함
    private List<Reply> reply;



}
