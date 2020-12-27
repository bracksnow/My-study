package hello.core.sigleton;

import hello.core.AppConfig;
import hello.core.Member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingleTest {
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean(MemberService.class);
        MemberService memberService2 = ac.getBean(MemberService.class);

        System.out.println(memberService1);
        System.out.println(memberService2);
        //스프링 컨테이너는 일반적으로 싱글톤패턴으로 객체를 생성한다
        //공유필드는 주의할 것
        }

}
