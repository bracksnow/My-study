package hello.hellomember.service;

import hello.hellomember.MemoryMemberRepository;
import hello.hellomember.domain.Member;
import hello.hellomember.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Service - 컴포넌트 방식으로 스프링이 컨트롤러로 지정하기 위해서 필요
public class MemberService {

    private final MemberRepository memberRepository;

    //@Autowired - 스프링이 컨트롤러에 객체를 연결해주는 것
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}


