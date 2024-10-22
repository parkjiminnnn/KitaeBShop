package inhatc.cse.kitaebshop.item.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {
    private Long id;            // 아이디
    private String itemNm;      // 상품명
    private int price;          // 가격
    private int stockNumber;    // 재고 수량
    private String itemDetail;  // 상품 상세 설명
}
