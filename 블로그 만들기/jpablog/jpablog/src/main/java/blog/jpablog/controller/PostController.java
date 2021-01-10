package blog.jpablog.controller;

import blog.jpablog.domain.Post;
import blog.jpablog.repository.MemberRepository;
import blog.jpablog.service.MemberService;
import blog.jpablog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;//생성자 주입

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size=3, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
        model.addAttribute("post", postService.watchList(pageable));
        return "post/list";
    }

    @GetMapping("/post/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.detailView(id));
        return "post/detail";
    }

    @GetMapping("/post/{id}/updateForm")
    public String updateForm(@PathVariable Long id, Model model) {
        model.addAttribute("post", postService.detailView(id));
        return "post/updateForm";
    }

    // USER 권한이 필요
    @GetMapping("/post/saveForm")
    public String saveForm() {
        return "post/saveForm";
    }

}
