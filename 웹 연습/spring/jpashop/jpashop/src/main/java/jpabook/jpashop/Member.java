package jpabook.jpashop;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue //Member엔터티의 기본키를 id로 두고 id가 자동으로 생성되도록 한 것
    private Long id;
    private String username;
}
