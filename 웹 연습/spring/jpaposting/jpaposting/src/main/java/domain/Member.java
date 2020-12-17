package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;//아이디나 이메일을 입력받는 것을 PK값으로

    private String name;//이름

    private String password;//비밀번호

    private String checkPassword;//비밀번호 확인

    @Embedded
    private Birth birth;//생년월일을 입력

    @Enumerated(EnumType.STRING)
    private Sex sex;//성별은 [male, female]로 구분

    @OneToMany(mappedBy = "member")//FK값이 가까운 엔터티에 연결
    private List<Post> posts = new ArrayList<>();
}
