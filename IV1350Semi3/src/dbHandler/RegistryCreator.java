package dbHandler;

public class RegistryCreator {
    private ItemRegistry itemReg = new ItemRegistry();
    private CustomerRegistry customerReg = new CustomerRegistry();
    private InventoryRegistry inventoryReg = new InventoryRegistry();
    private AccountingRegistry accountingReg = new AccountingRegistry ();

    /**Constructor**/
    public RegistryCreator(CustomerRegistry customerReg, ItemRegistry itemReg, AccountingRegistry accountingReg, InventoryRegistry inventoryReg) throws Exception {
        this.customerReg = customerReg;
        this.itemReg = itemReg;
        this.accountingReg = accountingReg;
        this.inventoryReg = inventoryReg;
    }
    /**Get methods**/
    public ItemRegistry getItemRegistry()
    {
        return itemReg;
    }
    public CustomerRegistry getCustomerRegistry(){
    return customerReg;
    }
    public InventoryRegistry getInventoryRegistry()
    {
        return inventoryReg;
    }
    public AccountingRegistry getAccountingRegistry()
    {
        return accountingReg;
    }
}
