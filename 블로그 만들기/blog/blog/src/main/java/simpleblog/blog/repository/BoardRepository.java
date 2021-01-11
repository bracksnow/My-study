package simpleblog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simpleblog.blog.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
