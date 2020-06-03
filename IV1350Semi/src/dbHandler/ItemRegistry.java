package dbHandler;

import DTO.ItemDTO;

public class ItemRegistry {
    /** constructor **/
    public ItemRegistry(){
    }

    public ItemDTO getItemSpecifications(int itemId, int itemQuantity) throws InvalidItemIdentifierException, DatabaseCanNotBeReachedException {
        ItemDTO item;
        try {
             item = getItemInfo(itemId);
        }
        catch (InvalidItemIdentifierException exc){
            throw exc;
        }
        item.setItemQuantity(itemQuantity);
        return item;
    }

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
