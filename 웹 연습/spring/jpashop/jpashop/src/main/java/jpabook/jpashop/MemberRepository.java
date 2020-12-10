package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository // DB의 입출력을 담당하는 역할->Component로 가능하나 가시성이 떨어짐
public class MemberRepository {

    @PersistenceContext //엔터티를 저장한다고 보면 될 듯, 엔터티매니저가 모든 것을 관리한다
    EntityManager em;

    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
