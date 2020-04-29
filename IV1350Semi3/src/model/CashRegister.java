package model;

import dbHandler.AccountingRegistry;

public class CashRegister {
    private AccountingRegistry accountingReg;
    /*Constructor*/
    public CashRegister(AccountingRegistry accountingReg){
        this.accountingReg = accountingReg;
    }
    public void accountingUpdate(double totalPrice) {
        accountingReg.UpdateAccountingRegistry(totalPrice);
    }
}
