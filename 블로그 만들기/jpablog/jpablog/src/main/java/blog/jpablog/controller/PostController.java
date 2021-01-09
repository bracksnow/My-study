package blog.jpablog.controller;

import blog.jpablog.repository.MemberRepository;
import blog.jpablog.service.MemberService;
import blog.jpablog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;//생성자 주입

    @GetMapping("/list")
    public String list(){
        return "board/list";
    }

}
