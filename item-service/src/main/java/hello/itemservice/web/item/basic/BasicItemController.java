package hello.itemservice.web.item.basic;

import hello.itemservice.domain.Item;
import hello.itemservice.domain.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    /**
     * Items 목록 조회
     * @param model
     * @return
     */
    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    /**
     * Item 상세 조회
     * @param itemId
     * @param model
     * @return
     */
    @GetMapping("/{itemId}")
    public String item(@PathVariable long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    /**
     * Item 저장 화면으로 이동
     * @return
     */
    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    /**
     * Item 저장 V1
     * @return
     */
//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                            @RequestParam int price,
                            @RequestParam Integer quantity,
                            Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        model.addAttribute("item", item);
        return "basic/item";
    }

    /**
     * Item 저장 V2
     * @return
     */
    //@PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item) {
        //, Model model

        //ModelAttribute는 Get을 자동으로해주고 addAttribute도 자동으로 해준다.
        itemRepository.save(item);
        //model.addAttribute("item", item); // 자동 추가, 생략 가능
        return "basic/item";
    }

    /**
     * Item 저장 V3
     * @return
     */
//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {
        //, Model model
        //@ModelAttribute("item")에 ("item")을 생략할수있다.
        //이렇게 되면 Item(Class)의 첫번째 단어를 소문자로 변경하여 addAttribute로 해준다.
        //ex) Item -> item, HelloData -> helloData로 html에서 사용할 수 있다.

        itemRepository.save(item);
        return "basic/item";
    }

    /**
     * Item 저장 V4
     * @return
     */
    @PostMapping("/add")
    public String addItemV4(Item item) {
        //, Model model
        //@ModelAttribute 자체를 생략 가능하다.

        itemRepository.save(item);
        return "basic/item";
    }

    /**
     * Item 정보 수정 화면으로 이동
     * @return
     */
    @GetMapping("/{itemId}/edit")
    public String editForm(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/editForm";
    }

    /**
     * Item 정보 수정
     * @param itemId
     * @param item
     * @return
     */
    @PostMapping("/{itemId}/edit")
    public String edit(@PathVariable Long itemId, @ModelAttribute("item") Item item) {
        itemRepository.update(itemId, item);
        return "redirect:/basic/items/{itemId}";
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("testA", 10000, 10));
        itemRepository.save(new Item("testB", 20000, 20));
    }
}
