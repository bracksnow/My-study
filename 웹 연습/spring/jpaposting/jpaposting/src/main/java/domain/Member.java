package domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 30)
    private String userId;//아이디

    @Column(nullable = false, length = 100)
    private String password;//비밀번호

    @Column(nullable = false, length = 30)
    private String name;//이름

    @Column(nullable = false, length = 50)
    private String email;//이메일

    @ColumnDefault("USER")
    private String role;//관리자, 유저

    @CreationTimestamp
    private Timestamp createDate;//생성날짜 - 자동입력됨


}
