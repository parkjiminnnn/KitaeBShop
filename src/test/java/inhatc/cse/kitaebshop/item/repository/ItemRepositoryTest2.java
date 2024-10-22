package inhatc.cse.kitaebshop.item.repository;

import inhatc.cse.kitaebshop.item.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest2 {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("상품 저장 테스트")
    public void insertItemTest(){
        Item item = Item.builder()
                .itemNm("추가 상품")
                .itemDetail("추가 상품 상세 설명")
                .price(20000)
                .stockNumber(200)
                .build();

        Item savedItem = itemRepository.save(item);
        assertEquals(savedItem.getId(), 7);
    }

    @Test
    public void findByItemNmTest(){
        List<Item> itemNmList = itemRepository.findByItemNm("추가 상품");
        itemNmList.forEach(item -> System.out.println(item));
        itemNmList.forEach(System.out::println);
    }
}