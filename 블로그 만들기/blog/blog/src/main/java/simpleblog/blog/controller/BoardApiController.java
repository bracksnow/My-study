package simpleblog.blog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import simpleblog.blog.domain.Board;
import simpleblog.blog.repository.BoardRepository;

import java.util.List;

//restful api->https://spring.io/guides/tutorials/rest/를 보고 적용
@RestController //데이터를 json으로 받을 때 사용한다
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardApiController {
    
    //의존성 주입->@RequiredArgsConstructor 사용
    private final BoardRepository boardRepository;

    @GetMapping("/boards")//검색을 하고 검색결과가 없는 경우 모든 결과를 보여준다
    List<Board> allBoards(@RequestParam(required = false, defaultValue = "") String title, @RequestParam(required = false, defaultValue = "") String content){
        if(StringUtils.isEmpty(title) && StringUtils.isEmpty(content)) {
            return boardRepository.findAll();
        } else {
            return boardRepository.findByTitleOrContent(title, content);
        }
    }
    @PostMapping("/boards")
    Board newBoard(@RequestBody Board newBoard) {
        return boardRepository.save(newBoard);
    }

    @DeleteMapping("/boards/{id}")//단건 삭제
    void deleteEmployee(@PathVariable Long id) {
        boardRepository.deleteById(id);
    }

    @GetMapping("/boards/{id}")
    Board one(@PathVariable Long id){
        return boardRepository.findById(id).orElse(null);//->optional로 감싸짐
    }
    @PutMapping("/boards/{id}")
    Board replaceBoard(@RequestBody Board newBoard, @PathVariable Long id) {

        return boardRepository.findById(id)
                .map(board -> {
                    board.setTitle(newBoard.getTitle());
                    board.setContent(newBoard.getContent());
                    return boardRepository.save(board);
                })
                .orElseGet(() -> {
                    newBoard.setId(id);
                    return boardRepository.save(newBoard);
                });
    }
    
}
