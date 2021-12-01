package hello.itemservice.domain;

import lombok.Data;

//실무에서는 Data를 많이 사용하지 않음
//@Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode. 모든 작업이 일어나기 때문에 의도치 않은 작업이 발생 할 수 있음
//원래는 @Getter @Setter 정도만 사용
//예제에서는 @Data를 사용함. 편의를 위해
@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

