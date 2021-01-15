package study.datajpa.repository;

import lombok.RequiredArgsConstructor;
import study.datajpa.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;

//구현체의 이름은 관례를 따르는 것이 중요!!-> 다르게 설정 시 설정이 필요
//~~~Impl이 관례임
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private EntityManager em;

    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m").getResultList();

    }
}
