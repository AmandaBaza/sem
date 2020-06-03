package dbHandler;

import DTO.ItemDTO;

public class ItemRegistry {
    /** constructor **/
    public ItemRegistry(){
    }

    /**
     * sets the items quantity and gets all Specifications about the item to return
     * @param itemId is the items identifier
     * @param itemQuantity the quantity if item (how many of it there is) which is to be set
     * @return the item as the object ItemDTO
     * @throws InvalidItemIdentifierException when there is no item with that id/ item id is invalid
     * @throws DatabaseCanNotBeReachedException when it's thrown from getItemInfo
     */
    public ItemDTO getItemSpecifications(int itemId, int itemQuantity) throws InvalidItemIdentifierException, DatabaseCanNotBeReachedException {
        ItemDTO item;
        item = getItemInfo(itemId);
        item.setItemQuantity(itemQuantity);
        return item;
    }

    /**
     * Get's all info there is about the item by calling the database
     * @param itemID items identifier
     * @return the item as the object ItemDTO
     * @throws InvalidItemIdentifierException when there is no item with that id/ item id is invalid
     * @throws DatabaseCanNotBeReachedException when the database can't be reached (though getAllItems)
     */
    public ItemDTO getItemInfo(int itemID) throws InvalidItemIdentifierException, DatabaseCanNotBeReachedException {
        ItemDTO[] allItems = getAllItems();
        //manually checking if database cannot be reached
        if(allItems == null){
            System.out.println("\nLOGGER: Cannot call Item Registry database");
            throw new DatabaseCanNotBeReachedException("Item Registry");
        }
        for (ItemDTO item: allItems) {
            if(item.getItemIdentifier() == itemID ){
                return item;
            }
        }
        throw new InvalidItemIdentifierException(itemID);

    }
    /**calls to database, instead of database it's manually added**/
    private ItemDTO[] getAllItems(){
        ItemDTO item1 = null;
        ItemDTO item2= null;
        ItemDTO item3= null;
        ItemDTO item4= null;
        ItemDTO item5= null;

            item1 = new ItemDTO(1, 12, "Apple", 12);
            item2 = new ItemDTO(2, 6, "Banana", 9);
            //item3 = new ItemDTO(3, 12, "Pear", 8);
            item4 = new ItemDTO(4, 25, "Orange", 10);
            item5 = new ItemDTO(5, 25, "Pineapple", 10);


        ItemDTO[] allItems = {item1,item2,item4,item5};
        return allItems;

        //manual representation if database cannot be reached
        //return null;
    }
}
