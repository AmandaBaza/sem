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
    public void payment(double totalPrice){
        notifyObserver(totalPrice);
        try {
            accountingReg.UpdateAccountingRegistry(totalPrice);
        }catch(DatabaseCanNotBeReachedException exc){
            String addOrRemoved = "added";
            if(totalPrice<0){
                addOrRemoved = "removed";
                totalPrice=totalPrice*(-1);
            }
            System.out.println("LOGGER: Couldn't reach database to update accounting Registry, the difference to be "+addOrRemoved+" :"+totalPrice);
        }
    }

    private void notifyObserver(double totalPrice) {
        totalRevenueObserver.newTotal(totalPrice);
    }

    public void addObserver(TotalRevenueView totalRevenueObs) {
        totalRevenueObserver = totalRevenueObs;
    }
}
