package model;

import dbHandler.AccountingRegistry;
import dbHandler.InventoryRegistry;
import model.DTO.ItemDTO;
import model.DTO.Receipt;

import java.util.ArrayList;

public class Sale {
    private double totalPrice = 0;
    private double amountPaid = 0;
    private double change = 0;
    private ArrayList<ItemDTO> allItems = new ArrayList<>();

    private AccountingRegistry accountingReg;
    private InventoryRegistry inventoryReg;
    private Receipt receipt;

    public Sale() {
        receipt = new Receipt();
        accountingReg = new AccountingRegistry();
        inventoryReg = new InventoryRegistry();
    }

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

        this.totalPrice = totalPrice + (item.getPrice()*itemQuantity);
    }
    private Boolean exists(ItemDTO itemDTO){
        for(ItemDTO itemExisting:allItems){
            if(itemExisting.getItemIdentifier() == itemDTO.getItemIdentifier()){
                return true;
            }
        }
        return false;
    }

    public void receipt(Sale sale){
        receipt.printReceipt(sale);
    }

    public double payment(double cash) throws Exception{
        amountPaid = cash;
        change = (amountPaid - totalPrice);
        if (change < 0){
            throw new Exception("Not enough money paid, need to pay more");
        }
        return change;
    }

    public void updateTotalPrice(double discount) {
        if (discount != 0)
            totalPrice = totalPrice * (1 - (discount/100));//100%-Discount in %
        else
            System.out.println ("No discount found");
    }

    public void inventoryUpdate() throws Exception {
        for (ItemDTO item: allItems) {
            inventoryReg.inventoryUpdate(item, item.getItemQuantity() );
        }
    }
    public double accountingUpdate() {
        return accountingReg.UpdateAccountingRegistry(totalPrice);
    }

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

}
