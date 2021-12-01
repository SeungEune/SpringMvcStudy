package hello.itemservice.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    private static final Map<Long, Item> story = new HashMap<>(); //static 사용
    private static Long sequence = 0L; //static 사용

    /**
     * Item 등록
     * @param item
     * @return
     */
    public Item save(Item item){
        item.setId(++sequence);
        story.put(item.getId(), item);
        return item;
    }

    /**
     * Item 조회
     * @param id
     * @return
     */
    public Item findById(Long id){
        return story.get(id);
    }

    /**
     * 모든 Item 조회
     * @return
     */
    public List<Item> findAll(){
        return new ArrayList<>(story.values());
    }

    /**
     * Item 정보 업데이트
     * @param id
     * @param updateItem
     */
    public void update(Long id, Item updateItem){
        Item findItem = findById(id);

        if(findItem == null || findItem.getId().equals("")){
            return;
        }

        findItem.setItemName(updateItem.getItemName());
        findItem.setPrice(updateItem.getPrice());
        findItem.setQuantity(updateItem.getQuantity());
    }

    /**
     * 모든 정보 초기화
     */
    public void clearStory(){
        story.clear();
    }

}
