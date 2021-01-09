package study.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.domain.Member;

import java.util.List;

public interface MemberInterfaceRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String name, int age);//메서드명으로 쿼리문을 날림->메서드명이 조금이라도 규칙에 맞지 앟으면 안됨

    @Query("select m from Member m where m.username=:username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
    //위의 것이 실무에서 가장 많이 사용하는 내용임 ->오타를 적는 경우엔 로딩시점에 오류가 발생
    
}
