package jpabook.jpashop.domain;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member; //주문 회원
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)//-mappedBy는 FK값이 가까운 것을 기준으로 한다
    //현재 FK값이 Order에 있으므로 Order엔터티를 MappedBy한다
    private List<OrderItem> orderItems = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery; //배송정보
    private LocalDateTime orderDate; //주문시간
    @Enumerated(EnumType.STRING)
    private OrderStatus status; //주문상태 [ORDER, CANCEL]
}