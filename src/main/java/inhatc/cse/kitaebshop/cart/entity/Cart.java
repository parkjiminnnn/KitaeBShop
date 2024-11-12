package inhatc.cse.kitaebshop.cart.entity;

import inhatc.cse.kitaebshop.common.entity.BaseEntity;
import inhatc.cse.kitaebshop.member.entity.Member;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart extends BaseEntity {

    @Id   // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name = "cart_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}

