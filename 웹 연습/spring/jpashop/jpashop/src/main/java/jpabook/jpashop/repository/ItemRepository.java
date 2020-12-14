package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ItemRepository {

    @PersistenceContext //나중에 영상을 보고 바꾸자!!
    EntityManager em;

    public void save(Item item){
        if(item.getId()==null){
            em.persist(item);
        }else{
            em.merge(item);
        }
    }
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }
    public List<Item> findAll() {//하나씩 가져오는 것은 상관없으나 여러개를 가져올땐 SQL문 사용해야함
        return em.createQuery("select i from Item i",Item.class).getResultList();
    }

}
