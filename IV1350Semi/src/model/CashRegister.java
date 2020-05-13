package model;

import dbHandler.AccountingRegistry;
import dbHandler.DatabaseCanNotBeReachedException;
import view.TotalRevenueView;

public class CashRegister {
    TotalRevenue totalRevenueObserver;


    private AccountingRegistry accountingReg;
    /**Constructor**/
    public CashRegister(AccountingRegistry accountingReg){
        this.accountingReg = accountingReg;
    }

    /**
     * Updates accounting Registry in AccountingRegistry
     * @param totalPrice value to update Accounting Registry with, that comes from the total price of the sale
     */
    public void payment(double totalPrice) throws DatabaseCanNotBeReachedException {
        notifyObserver(totalPrice);
        accountingReg.UpdateAccountingRegistry(totalPrice);
    }

    private void notifyObserver(double totalPrice) {
        totalRevenueObserver.newTotal(totalPrice);
    }

    public void addObserver(TotalRevenueView totalRevenueObs) {
        totalRevenueObserver = totalRevenueObs;
    }
}
