package dbHandler;

import java.util.ArrayList;

public class RegistryCreator {
    private ItemRegistry itemReg = new ItemRegistry();
    private CustomerRegistry customerReg = new CustomerRegistry();
    private InventoryRegistry inventoryReg = new InventoryRegistry();
    private AccountingRegistry accountingReg = new AccountingRegistry ();

    /**Constructor**/
    public RegistryCreator(CustomerRegistry customerReg, ItemRegistry itemReg, AccountingRegistry accountingReg, InventoryRegistry inventoryReg) {
        this.customerReg = customerReg;
        this.itemReg = itemReg;
        this.accountingReg = accountingReg;
        this.inventoryReg = inventoryReg;
    }

    public RegistryCreator() {

    }

    public ItemRegistry getItemRegistry()
    {
        return itemReg;
    }
    /*public ArrayList<CustomerRegistry> getCustomerReg()
    {
        return customerReg;
    }*/
    public InventoryRegistry getInventoryReg()
    {
        return inventoryReg;
    }
    public AccountingRegistry getAccountingReg()
    {
        return accountingReg;
    }
    /**
    public double getCostumerDiscount(String customerID) {
        double discount = 0;
        for(int i = 0; i <customerReg.size(); i++){
             discount = customerReg.get(i).getCustomerDiscount(customerID);
            if(discount != 0) {
                return discount;
            }
        }
        return discount;
    }
     **/
}
