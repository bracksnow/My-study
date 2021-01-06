package blog.jpablog.controller;

import blog.jpablog.repository.MemberRepository;
import blog.jpablog.service.MemberService;
import blog.jpablog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;//생성자 주입


}
