package jpabook.jpashop.domain;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Entity
@Getter @Setter
public class Delivery {
    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;
    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)//거의 String로 지정해주는 것이 좋음 그 이유는 나중에 DB에 상태정보가 추가될 경우 순서에 문제가 생길 수 있음
    private DeliveryStatus status; //ENUM [READY(준비), COMP(배송)]
}