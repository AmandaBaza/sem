package model;

import dbHandler.InventoryRegistry;
import model.DTO.ItemDTO;
import model.DTO.Receipt;

import java.util.ArrayList;

public class Sale {
    private double totalPrice = 0;
    private double amountPaid = 0;
    private double change = 0;
    private ArrayList<ItemDTO> allItems = new ArrayList<>();

    private InventoryRegistry IventoryReg;
    private Receipt receipt;

    public Sale() {
        receipt = new Receipt();
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

    public double payment(double cash) {
        amountPaid = cash;
        change = (amountPaid - totalPrice);
        return change;
    }

    public void updateTotalPrice(double discount) {
        if (discount != 0)
            totalPrice = totalPrice * (1 - discount);
        else
            System.out.println ("No discount found");
    }

    public void inventoryUpdate() throws Exception {
        allItems.forEach((itemDTO) ->
        {
            try {
                IventoryReg.inventoryUpdate(itemDTO, itemDTO.getItemQuantity() );
            } catch (Exception err) {
            }
        });
    }
    public void accountingUpdate() {
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
