package study.datajpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.datajpa.domain.Member;
import study.datajpa.dto.MemberDto;

import java.util.List;

public interface MemberInterfaceRepository extends JpaRepository<Member, Long> {

    List<Member> findByUsernameAndAgeGreaterThan(String name, int age);//메서드명으로 쿼리문을 날림->메서드명이 조금이라도 규칙에 맞지 앟으면 안됨

    @Query("select m from Member m where m.username=:username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
    //위의 것이 실무에서 가장 많이 사용하는 내용임 ->오타를 적는 경우엔 로딩시점에 오류가 발생


    @Query("select m.username from Member m")
    List<String> findUserName();

    @Query("select new study.datajpa.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();

    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String>names);

    //단건 조회에서 데이터가 있는지 없는지 확신이 없는 경우엔 optional로 감싸주기
    /*
    public List<Member> findByPage(int age, int offset, int limit) {
        return em.createQuery("select m from Member m where m.age = :age order by
                m.username desc")
                        .setParameter("age", age)
                        .setFirstResult(offset)
                        .setMaxResults(limit)
                        .getResultList();
    }
    public long totalCount(int age) {
        return em.createQuery("select count(m) from Member m where m.age = :age",
                Long.class)
                .setParameter("age", age)
                .getSingleResult();
    }
    */


    Page<Member> findByAge(int age, Pageable pageable);
    //해당 값을 출력하고 싶을 땐 dto사용하기
    Slice<Member> sliceFindByAge(int age, Pageable pageable);

    @Modifying
    @Query("update Member m set m.age = m.age+1 where m.age>=1")
    int bulkAgePlus(int age);//벌크연산은 영속성 컨텍스트를 무시
    //벌크연산을 한 뒤에는 영속성 컨텍스트를 날려야한다


    @Query("select m from Member m left join fetch m.team")
    List<Member> findMemberFetchJoin();

    @EntityGraph(attributePaths = {"team"})
    List<Member> findAll();
}
