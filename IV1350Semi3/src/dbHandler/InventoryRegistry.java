package dbHandler;
import model.DTO.ItemDTO;

public class InventoryRegistry {
    private ItemDTO item;
    private int quantity;
    private InventoryRegistry[] inventoryReg = new InventoryRegistry[4];

    /*Constructors*/
    public InventoryRegistry(ItemDTO item, int quantity){
        this.item= item;
        this.quantity= quantity;
    }
    public InventoryRegistry(){
        createInv();
    }

    /*Included 0 in exception, not cause any data would be wrong after the update if
    the quantity was 0, but it's an unnecessary call*/
    public void inventoryUpdate(ItemDTO itemBought, int quantity) throws Exception{
        Boolean found=false;
        for (InventoryRegistry itemR:inventoryReg) {
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

    /*Instead of database*/
    private void createInv() {
        InventoryRegistry item1 = new InventoryRegistry(new ItemDTO(1, 12, "Apple", 12),200) ;
        InventoryRegistry item2 = new InventoryRegistry(new ItemDTO(2, 6, "Banana", 9),50);
        InventoryRegistry item3 = new InventoryRegistry(new ItemDTO(3, 12, "Pear", 8),30);
        InventoryRegistry item4 = new InventoryRegistry(new ItemDTO(4, 25, "Orange", 10),10);
        this.inventoryReg = new InventoryRegistry[]{item1, item2, item3, item4};
    }
}
