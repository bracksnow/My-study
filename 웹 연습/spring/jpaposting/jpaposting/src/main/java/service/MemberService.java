package service;

import Repository.MemberRepository;
import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {//회원가입, 회원수정, 회원검색, 회원삭제기능

    @Autowired
    private MemberRepository memberRepository;

    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findByUserId(member.getUserId());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    @Transactional
    public void join(Member member){//회원가입
        validateDuplicateMember(member);
        memberRepository.save(member);
    }
    
    @Transactional
    public void modify(Member member){//회원수정
        
    }

}
