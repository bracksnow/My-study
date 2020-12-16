package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;//DB에 자동으로 생성되는 기본키 역할

    private String name;//이름

    private String password;//비밀번호

    private String checkPassword;//비밀번호 확인

    @Embedded
    private Birth birth;//생년월일을 입력

    @Enumerated(EnumType.STRING)
    private Sex sex;//성별은 [남, 여]로 구분

    @OneToMany
    private List<Post> posts = new ArrayList<>();
}
