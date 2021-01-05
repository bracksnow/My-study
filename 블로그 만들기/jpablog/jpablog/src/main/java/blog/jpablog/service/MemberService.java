package blog.jpablog.service;


import blog.jpablog.domain.Member;
import blog.jpablog.domain.Role;
import blog.jpablog.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)//기본적으로 readonly로 지정됨
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
        member.setRole(Role.USER);//회원등급
        memberRepository.save(member);
    }
    
    @Transactional
    public void modify(Member member){//회원수정
        Member target = memberRepository.getOne(member.getId());
        if(target==null) {
            throw new IllegalStateException("존재하지 않는 회원입니다");
        }else{
            target.setName(member.getName());//이름, 이메일, 비밀번호만 수정
            target.setEmail(member.getEmail());
            target.setPassword(member.getPassword());
        }
    }

    @Transactional
    public void remove(Member member){//회원삭제
        memberRepository.deleteById(member.getId());

    }
    
    public Member findone(String userId){//회원찾기
         return memberRepository.findOneByUserId(userId);
    }

    public List<Member> findMembers() {//전체회원 찾기
        return memberRepository.findAll();
    }

}
