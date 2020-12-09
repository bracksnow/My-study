package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControler {

    @GetMapping("hello")//hello로 접근하면 아래의 컨트롤러를 호출한다는 의미
    public String hello(Model model){
        model.addAttribute("data", "Hello");
        //이렇게 작성을 할 경우 화면에 model을 날릴 때 data라는 것을 날리는데 이 값이 hello로 화면에 보인다
        return "hello";
    }
}
