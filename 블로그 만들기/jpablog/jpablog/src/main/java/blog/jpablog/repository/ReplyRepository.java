package blog.jpablog.repository;

import blog.jpablog.domain.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Modifying
    @Query(value="INSERT INTO reply(memberId, postId, content, createDate) VALUES(?1, ?2, ?3, now())", nativeQuery = true)
    int querySave(Long memberId, Long postId, String content);
}
