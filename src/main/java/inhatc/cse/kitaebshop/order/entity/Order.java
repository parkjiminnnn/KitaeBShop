package inhatc.cse.kitaebshop.order.entity;

import inhatc.cse.kitaebshop.common.entity.BaseEntity;
import inhatc.cse.kitaebshop.member.entity.Member;
import inhatc.cse.kitaebshop.order.constant.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {

    @Id   // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name = "order_id")
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private LocalDateTime orderDate; // 주문일

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus; // 주문 상태



}
