package blog.jpablog.repository;

import blog.jpablog.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    public List<Member> findByUserId(String UserId);

    public Member findOneByUserId(String id);
}
