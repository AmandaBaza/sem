package model;

import dbHandler.AccountingRegistry;
import dbHandler.InventoryRegistry;
import DTO.ItemDTO;
import DTO.Receipt;

import java.util.ArrayList;

public class Sale {
    private double totalPrice = 0;
    private double totalVAT =0;
    private double amountPaid = 0;
    private double change = 0;
    private double discount = 0;
    private ArrayList<ItemDTO> allItems = new ArrayList<>();
    private InventoryRegistry inventoryReg;

    /**
     * Constructor
     */
    public Sale(){
        inventoryReg = new InventoryRegistry();
    }

    /**
     * Adds item to sale
     * @param item to be added
     * @param itemQuantity is how many of that item that exists in the Sale
     */
    public void addItem(ItemDTO item, int itemQuantity){
        if(exists(item)){
            for(ItemDTO itemExisting:allItems){
                if(itemExisting.getItemIdentifier() == item.getItemIdentifier()){
                    itemExisting.setItemQuantity(itemExisting.getItemQuantity() +itemQuantity);
                }
            }
        }
        else {
            allItems.add(item);
        }
        this.totalPrice = totalPrice + ((item.getPrice()+item.getVAT())*itemQuantity);
        this.totalVAT = totalVAT + item.getVAT()*itemQuantity;
    }
    private Boolean exists(ItemDTO itemDTO){
        for(ItemDTO itemExisting:allItems){
            if(itemExisting.getItemIdentifier() == itemDTO.getItemIdentifier()){
                return true;
            }
        }
        return false;
    }

    /**
     * Payment logic in sale
     * @param cash how much money is used to pay with
     * @return change, rounded to two decimals
     * @throws Exception is thrown if they payed too little (less than total price)
     */
    public double payment(double cash) throws Exception{
        amountPaid = cash;
        change = (amountPaid - totalPrice);
        if (change < 0){
            throw new Exception("Not enough money paid, need to pay more");
        }
        //rounding it manually to 2 decimals
        change = change*100;
        change = Math.round(change);
        change = change/100;
        return change;
    }

    /**
     * Updates the total price to after discount
     * @param discount the number of percent (%) that is to be removed from the price
     */
    public void updateTotalPrice(double discount) {
        this.discount = discount;
        if (discount != 0)
            totalPrice = totalPrice * (1 - (discount/100));//100%-Discount in %
        else
            System.out.println ("No discount found");
    }

    /**
     * Update Inventory with all the items that was been bought
     * @throws Exception if exception is thrown from inventoryUpdate
     */
    public void inventoryUpdate() throws Exception {
        for (ItemDTO item: allItems) {
            inventoryReg.inventoryUpdate(item, item.getItemQuantity() );
        }
    }

    /**
     * Get methods
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    public double getAmoutPaid() {
        return amountPaid;
    }

    public double getChange() {
        return change;
    }

    public ArrayList<ItemDTO> getAllItems() {
            return allItems;
    }

    public double getTotalVAT() {
        return totalVAT;
    }

    public double getDiscount() {
        return discount;
    }
}
