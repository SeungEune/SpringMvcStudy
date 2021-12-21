package hello.itemservice.domain.item;

import hello.itemservice.domain.Item;
import hello.itemservice.domain.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach(){
        itemRepository.clearStory();
    }

    /**
     * Item 저장 기능을 테스트합니다.
     */
    @Test
    void save(){
        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(saveItem.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    /**
     * 모든 목록 조회 기능을 테스트합니다.
     */
    @Test
    void findAll(){
        //given
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);

        itemRepository.save(item1);
        itemRepository.save(item2);

        //when
        List<Item> findAllItemList = itemRepository.findAll();

        //then
        assertThat(findAllItemList.size()).isEqualTo(2);
        assertThat(findAllItemList).contains(item1, item2);
    }

    /**
     * Item 업데이트 기능을 테스트합니다.
     */
    @Test
    void updateItem(){
        //given
        Item item = new Item("ItemA", 10000, 10);

        Item savedItem = itemRepository.save(item);
        Long savedId = savedItem.getId();

        //when
        Item updateItem = new Item("ItemB", 20000, 20);
        itemRepository.update(savedId, updateItem);

        //then
        Item findItem = itemRepository.findById(savedId);
        assertThat(findItem.getItemName()).isEqualTo(item.getItemName());
    }
}
