package handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController//->뷰 없이 데이터로 보여줌
@ControllerAdvice//이 어노테이션으로 모든 컨트롤러의 오류를 HTML태그를 이용해서 보여준다
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public String handleArguementException(Exception e){
        return "<h1>"+e.getMessage()+"<h1>";
    }
}
