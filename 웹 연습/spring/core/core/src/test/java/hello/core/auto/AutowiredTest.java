package hello.core.auto;

import hello.core.Member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    public void AutoWiredOption(){
        ApplicationContext ac  = new AnnotationConfigApplicationContext(TestBean.class);
    }
    static class TestBean{

        @Autowired(required = false)//required = false이기 때문에 호출이 안됨 
        public void setBean1(Member noBean1){
            System.out.println(noBean1);

        }
        @Autowired
        public void setBean2(@Nullable Member noBean2){
            System.out.println(noBean2);
        }
        @Autowired
        public void setBean2(Optional<Member> nobean3){
            System.out.println(nobean3);
        }

    }
}
