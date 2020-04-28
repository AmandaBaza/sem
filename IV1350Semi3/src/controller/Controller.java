package controller;

import dbHandler.*;
import model.*;
import model.DTO.*;


public class Controller {
    private ItemRegistry itemReg;
    private Sale sale;
    private CustomerRegistry customerReg;
    private CashRegister cashReg;

    public void startNewSale() {
        sale = new Sale();
        customerReg = new CustomerRegistry();
        cashReg = new CashRegister();
        itemReg = new ItemRegistry();
    }


    /**
     * Class constructor
     **/
    public Controller(RegistryCreator regCreator) {
        this.itemReg = regCreator.getItemRegistry();
    }

    public ItemDTO callAddItem(int itemIdentifier, int itemQuantity) {
        ItemDTO item = itemReg.getItemSpecifications(itemIdentifier, itemQuantity);
            sale.addItem(item, itemQuantity);
            return item;
    }
    public String callGetName(ItemDTO item) {
        return item.getName();
    }
    public double callGetPrice(ItemDTO item) {
        return item.getPrice();
    }
    public float callGetVAT(ItemDTO item) {
        return item.getVAT();
    }

    private void checksForDiscount(String customerID) {
        double discount = customerReg.getCustomerDiscount(customerID);
        sale.updateTotalPrice(discount);
    }

    public void startPayment(String customerID) throws Exception {
        checksForDiscount(customerID);
        cashReg.accountingUpdate(sale.getTotalPrice());
        sale.inventoryUpdate();
        sale.accountingUpdate();
    }

    //returns total price to pay
    public double totalPrice(){
        return sale.getTotalPrice();
    }

    public double payment(double cash) throws Exception {
        double change = sale.payment(cash);
        sale.receipt(sale);
        return change;
    }

}
