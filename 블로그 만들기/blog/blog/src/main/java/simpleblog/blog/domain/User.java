package simpleblog.blog.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "이메일 양식에 맞지 않습니다")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$", message = "적어도 대소문자, 특수문자 1개씩 입력해야합니다(8~20자리)")
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;//이것으로 권한부여 예정

    private Boolean enabled;
}
