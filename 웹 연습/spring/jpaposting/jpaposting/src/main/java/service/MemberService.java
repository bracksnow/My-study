package service;

import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MemberRepository;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public String memberSave(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
        }

    public void validateDuplicateMember(Member member) {
        List<Member> members = memberRepository.findById(member.getId());
        if(!members.isEmpty()){
            throw new IllegalStateException("이미 등록된 아이디입니다");
        }//중복된 아이디 체크
    }
}


