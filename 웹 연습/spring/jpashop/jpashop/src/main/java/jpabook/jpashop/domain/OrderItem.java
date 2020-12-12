package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item; //주문 상품-다대일의 관계

    @ManyToOne(fetch = FetchType.LAZY)//Xtoone인 것들은 기본이 EAGER이다. EAGER은 SQL문을 날릴때 한꺼번에 로딩을 하기 때문에 N+1문제가 발생할 가능성이 높다
    @JoinColumn(name = "order_id")
    private Order order; //주문-다대일의 관계

    private int orderPrice; //주문 가격
    private int count; //주문 수량
}
