package study.datajpa;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.domain.Member;
import study.datajpa.domain.Team;
import study.datajpa.repository.MemberRepository;
import study.datajpa.repository.TeamInterfaceRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
public class MemberTest {
    @PersistenceContext
    EntityManager em;
    @Autowired
    TeamInterfaceRepository teamInterfaceRepository;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);
        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
//초기화
        em.flush();
        em.clear();
//확인
        List<Member> members = em.createQuery("select m from Member m",
                Member.class)
                .getResultList();
        for (Member member : members) {
            System.out.println("member=" + member);
            System.out.println("-> member.team=" + member.getTeam());
        }
    }
    @Test
    public void findMemberLazy(){
        //Member1->teamA
        //Member2->teamB
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        teamInterfaceRepository.save(teamA);
        teamInterfaceRepository.save(teamB);
        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 10, teamB);
        em.flush();
        em.clear();

        //N+1문제가 발생->N개의 멤버를 조회하는데 이후에 N개의 팀 조회가 발생한다
        List<Member> members = memberRepository.findAll();
        for(Member member: members){
            System.out.println(member.getUsername());
            System.out.println(member.getTeam().getName());
        }

    }
}