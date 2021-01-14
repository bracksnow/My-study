package study.datajpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import study.datajpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    EntityManager em;

    public Member save(Member member) {
        em.persist(member);
        return member;
    }
    public Member find(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}