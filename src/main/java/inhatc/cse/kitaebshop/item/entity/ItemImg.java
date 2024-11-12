package inhatc.cse.kitaebshop.item.entity;

import inhatc.cse.kitaebshop.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemImg extends BaseEntity {
    @Id   // 기본키 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // autoincrement
    @Column(name = "item_img_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private String imgName;         // 이미지 이름

    private String oriImgName;      // 원본 이미지 이름

    private String imgUrl;          // 이미지 경로

    private String repImgYn;        // 대표 이미지 여부

    public void updateItemImage(String oriImgName, String imgName, String imgUrl){
        this.oriImgName = oriImgName;
        this.imgName = imgName;
        this.imgUrl = imgUrl;
    }
}
