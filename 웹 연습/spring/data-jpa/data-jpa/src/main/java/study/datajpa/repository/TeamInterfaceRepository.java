package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.datajpa.domain.Team;

//스프링이 알아서 구현체를 만들어줘 인터페이스만 사용가능(프록시)
public interface TeamInterfaceRepository extends JpaRepository<Team, Long> {
}
