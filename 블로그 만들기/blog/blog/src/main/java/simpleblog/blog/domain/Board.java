package simpleblog.blog.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Data
public class Board extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "제목을 입력하세요")
    private String title;

    @Column(nullable = false)
    @NotBlank(message = "내용을 입력하세요")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;




    






}
