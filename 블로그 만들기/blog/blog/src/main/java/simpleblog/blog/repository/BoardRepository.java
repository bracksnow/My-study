package simpleblog.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import simpleblog.blog.domain.Board;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    //예시
    //List<Person> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
    List<Board> findByTitleOrContent(String title, String content);

    Page<Board> findByTitleContainingOrContentContaining(String title, String content, Pageable pageable);
}
