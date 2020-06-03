package controller;

import dbHandler.*;
import model.*;
import DTO.*;
import view.TotalRevenueView;

/**
 * View calls all model classes through here.
 */
public class Controller {
    private ItemRegistry itemReg;
    private Sale sale;
    private CustomerRegistry customerReg;
    private CashRegister cashReg;
    private Receipt receipt;
    private TotalRevenueView totalRevenueObs;

    /**starts a new sale*/
    public void startNewSale(){
        sale = new Sale();
        receipt = new Receipt();
    }

    /**
     * Creates a new instance.
     * @registryCreator is used for all operation calls.
     **/
    public Controller(RegistryCreator regCreator) {
        this.customerReg = regCreator.getCustomerRegistry();
        this.cashReg = new CashRegister(regCreator.getAccountingRegistry());
        this.itemReg = regCreator.getItemRegistry();
    }

    /**
     * method to get sale to add item, and
     * @param itemIdentifier is used to identify the item
     * @param itemQuantity shows how many of the item is to be added
     * @return the item as a ItemDTO
     * TODO
     * @throws DatabaseCanNotBeReachedException
     * @throws InvalidItemIdentifierException
     */
    public ItemDTO callAddItem(int itemIdentifier, int itemQuantity) throws InvalidItemIdentifierException, DatabaseCanNotBeReachedException {
        ItemDTO item;
        item = itemReg.getItemSpecifications(itemIdentifier, itemQuantity);
        sale.addItem(item, itemQuantity);
        return item;
    }

    /**
     *  Gets customers discount and updates the price according to it
     * @param customerID is used to identify costumer and therefor find their discount
     */
    public void checksForDiscount(String customerID) throws DatabaseCanNotBeReachedException {
        double discount = 0;
        discount = customerReg.getCustomerDiscount(customerID);
        sale.updateTotalPrice(discount);
    }

    /**
     * Starts the payment by updates accounting registry and updates the inventory (though Sale)
     * @throws Exception TODO
     */
    public void startPayment() {
        cashReg.addObserver(totalRevenueObs);
        cashReg.payment(sale.getTotalPrice());
        sale.inventoryUpdate();
    }
    /**
     *  returns total price to pay
     */
    public double totalPrice(){
        return sale.getTotalPrice();
    }

    /**
     * Handles the payment logic, taking the money into Sale, and calls the printReceipt method to make the receipt
     * @param cash is the amount of money that is payed
     * @return the change
     * @throws SaleException from Sale.payment if cash is negative (not enough money paid)
     */
    public double payment(double cash) throws SaleException {
        double change = sale.payment(cash);
            //receipt.printReceipt(sale);
        return change;
    }

    /**
     * adds observer to be used for this sale
     * @param tR is set to be the totalRevenueObserver to be used for this sale
     */
    public void addRevenueObserver(TotalRevenueView tR) {
        totalRevenueObs = tR;
    }
}
