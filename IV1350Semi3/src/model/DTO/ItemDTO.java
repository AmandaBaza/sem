package model.DTO;

public class ItemDTO {
    private String name; //Item name
    private int id; //Item Identifier
    private double price; //Item price, Where vat is included
    private int VAT; //Item VAT in %
    private int quantity; //quantity of the item (how many there are of the same item)

    public ItemDTO (int itemId, int VAT, String name, double price) throws Exception{
        if((VAT != 25 && VAT != 12 && VAT != 6)){
            throw new Exception("VAT can only be 25%, 12% or 6%");
        }
        this.id = itemId;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
    }

    public String getName() {
        return name;
    }
    public int getItemIdentifier() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public int getVAT() {
        return VAT;
    }
    public int getItemQuantity() {
        return quantity;
    }
   /**Sets the new quantity for an item **/
    public void setItemQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}
