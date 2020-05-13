package dbHandler;
import DTO.ItemDTO;

public class InventoryRegistry {
    private ItemDTO item;
    private int quantity;

    /**Constructor**/
    public InventoryRegistry(ItemDTO item, int quantity){
        this.item= item;
        this.quantity= quantity;
    }
    /**Constructor**/
    public InventoryRegistry()  {
    }

    /**
     * @param itemBought the item bought
     * @param quantity how many of that item
     * @throws Exception if the remaining number of the item in Inventory is negative (since you cant store negative number of items)
     * @throws Exception if the item does not exist in the inventory, since you cant buy an item that is not in the store.
     */

    public void inventoryUpdate(ItemDTO itemBought, int quantity) throws Exception{
        Boolean found=false;
        InventoryRegistry[] allInInventoryRegistry = getInventoryRegistry();
        if(allInInventoryRegistry == null) {
            System.out.println("\nLOGGER: Cannot call Inventory Registry database");
            throw new DatabaseCanNotBeReachedException("Inventory Registry");
        }
        for (InventoryRegistry itemR : allInInventoryRegistry) {
            if (itemR.item.getItemIdentifier() == itemBought.getItemIdentifier()) {
                if ((itemR.quantity - quantity) < 0) {
                    throw new IllegalAccessException("quantity of an item in Inventory Registry can't be negative");
                } else {
                    itemR.quantity = itemR.quantity - quantity;
                }
                found = true;
            }
        }
        if (!found)
            throw new InvalidItemIdentifierException(itemBought.getItemIdentifier());
    }

    /** calls to database (instead of database it's manually added for this assignment)**/
    private InventoryRegistry[] getInventoryRegistry() {
        InventoryRegistry item1 = new InventoryRegistry(new ItemDTO(1, 12, "Apple", 12), 200);
        InventoryRegistry item2 = new InventoryRegistry(new ItemDTO(2, 6, "Banana", 9), 50);
        //InventoryRegistry item3 = new InventoryRegistry(new ItemDTO(3, 12, "Pear", 8), 30);
        InventoryRegistry item4 = new InventoryRegistry(new ItemDTO(4, 25, "Orange", 10), 10);
        //return new InventoryRegistry[]{item1, item2, item4};

        //manual representation if database cannot be reached
        return null;
    }
}
