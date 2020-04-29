package model;

import dbHandler.AccountingRegistry;

public class CashRegister {
    private AccountingRegistry accountingReg;
    /*Constructor*/
    public CashRegister(AccountingRegistry accountingReg){
        this.accountingReg = accountingReg;
    }
    /*Updates accounting Registry in AccountingRegistry*/
    public void accountingUpdate(double totalPrice) {
        accountingReg.UpdateAccountingRegistry(totalPrice);
    }
}
