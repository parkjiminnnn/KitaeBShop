package inhatc.cse.kitaebshop.item.repository;

import inhatc.cse.kitaebshop.item.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void findByItemNm() {
    }

    @Test
    void findByItemNmLike() {
        List<Item> itemList = itemRepository.findByItemNmLike("%1%");
        itemList.forEach(System.out::println);
    }

    @Test
    public void findByPriceLessThanOrderByPriceDescTest(){
        List<Item> itemList = itemRepository.findByPriceLessThanOrderByPriceDesc(30000);
        itemList.forEach(System.out::println);
    }
}