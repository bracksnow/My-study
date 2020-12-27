package Repository;

import domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // 생략가능->JpaRepository를 받음으로 생략이 가능해짐
public interface MemberRepository extends JpaRepository<Member, Integer> {

    
}
