package simpleblog.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import simpleblog.blog.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
