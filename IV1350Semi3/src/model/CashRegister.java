package model;

import dbHandler.AccountingRegistry;
import dbHandler.DatabaseCanNotBeReachedException;

public class CashRegister {
    private AccountingRegistry accountingReg;
    /**Constructor**/
    public CashRegister(AccountingRegistry accountingReg){
        this.accountingReg = accountingReg;
    }

    /**
     * Updates accounting Registry in AccountingRegistry
     * @param totalPrice value to update Accounting Registry with, that comes from the total price of the sale
     */
    public void accountingUpdate(double totalPrice) throws DatabaseCanNotBeReachedException {
            accountingReg.UpdateAccountingRegistry(totalPrice);
    }
}
