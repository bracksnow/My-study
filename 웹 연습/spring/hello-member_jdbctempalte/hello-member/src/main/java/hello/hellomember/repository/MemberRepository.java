package hello.hellomember.repository;

import hello.hellomember.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);//없으면 null값이 반환되는데 이것은 optional으로 감싸준다
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
