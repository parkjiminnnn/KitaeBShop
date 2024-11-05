package inhatc.cse.kitaebshop.order.entity;

import inhatc.cse.kitaebshop.member.entity.Member;
import inhatc.cse.kitaebshop.order.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id   // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate; // 주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 주문 상태

}
