package inhatc.cse.kitaebshop.order.entity;

import inhatc.cse.kitaebshop.common.entity.BaseEntity;
import inhatc.cse.kitaebshop.item.entity.Item;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem extends BaseEntity {
    @Id   // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice; // 주문 가격

    private int count;  // 주문 수량

}
