package simpleblog.blog.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Table(name = "user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;//이것으로 권한부여 예정

    @OneToMany
    private List<Board> boards;

    private Boolean enabled;
}
