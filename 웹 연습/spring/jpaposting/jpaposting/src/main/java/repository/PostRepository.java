package repository;

import domain.Post;
import domain.Postsearch;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PostRepository {//취소, 수정, 검색 구현해야함

    @PersistenceContext
    EntityManager em;

    public void save(Post post){
        em.persist(post);
    }
    public void findOne(Long id){
        em.find(Post.class, id);
    }
    public List<Post> findAll(Postsearch postsearch){
        //검색기능은 querydsl공부한 후 추가하기
    }
}
