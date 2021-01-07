package study.datajpa.domain;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name"})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")//FK가 없는 곳에 mapped를 걸어준다 -> 서로 연결되는 것임
    ArrayList<Member> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
}
