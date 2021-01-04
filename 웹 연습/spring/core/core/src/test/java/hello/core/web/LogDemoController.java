package hello.core.web;


import hello.core.common.Mylogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final Mylogger mylogger;

    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();
        mylogger.setRequestURL(requestURL);
        mylogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
