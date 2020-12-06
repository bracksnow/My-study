package hello.hellomember;

import hello.hellomember.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 스피링에 직접 등록하는 방식임
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memoryMemberRepository());
    }

    @Bean
    public MemoryMemberRepository memoryMemberRepository(){
        return new MemoryMemberRepository();
    }
    //Memberservice는 Memorymemberrepository가 필요
    //이렇게 직접 주입해주는 방식은 상황에 따라 구현 클래스가 변경될 경우에 사용
    //->이 경우에는 추후에 DB를 변경할 예정임
}
