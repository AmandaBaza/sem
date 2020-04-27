package dbHandler;

import model.DTO.ItemDTO;
import java.util.ArrayList;

public class ItemRegistry {
    /** constructor **/
    public ItemRegistry(){
    }

    public ItemDTO getItemSpecifications(int itemId, int itemQuantity) {
        ItemDTO item = getItemInfo(itemId);
        item.setItemQuantity(itemQuantity);
        return item;
    }

    public ItemDTO getItemInfo(int itemID) {
        for (ItemDTO item: allItems()) {
            if(item.getItemIdentifier() == itemID ){
                return item;
            }
        }
        return null;
    }

    private ItemDTO[] allItems(){
        ItemDTO item1 = new ItemDTO(1, 12, "Apple", 12);
        ItemDTO item2 = new ItemDTO(2, 6, "Banana", 9);
        ItemDTO item3 = new ItemDTO(3, 12, "Pear", 8);
        ItemDTO item4 = new ItemDTO(4, 25, "Orange", 10);
        ItemDTO item5 = new ItemDTO(5, 25, "Pineapple", 10);
        ItemDTO[] allItems = {item1,item2,item3,item4,item5};
        return allItems;
    }
}
