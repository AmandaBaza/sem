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
        for (InventoryRegistry itemR:getInventoryRegistry()) {
            if(itemR.item.getItemIdentifier() == itemBought.getItemIdentifier()){
                if ((itemR.quantity - quantity) < 0){
                    throw new Exception("quantity of an item in Inventory Registry can't be negative");
                }
                else {itemR.quantity= itemR.quantity - quantity;}
                found=true;
            }
        }
        if(!found)
            throw new Exception("Item not found in the Inventory Registry");
    }

    /** TODO
     * calls to database, instead of database it's manually added**/
    private InventoryRegistry[] getInventoryRegistry() throws Exception{
            InventoryRegistry item1 = new InventoryRegistry(new ItemDTO(1, 12, "Apple", 12), 200);
            InventoryRegistry item2 = new InventoryRegistry(new ItemDTO(2, 6, "Banana", 9), 50);
            InventoryRegistry item3 = new InventoryRegistry(new ItemDTO(3, 12, "Pear", 8), 30);
            InventoryRegistry item4 = new InventoryRegistry(new ItemDTO(4, 25, "Orange", 10), 10);
            return new InventoryRegistry[]{item1, item2, item3, item4};
    }
}
