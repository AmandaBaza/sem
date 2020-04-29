package dbHandler;

public class AccountingRegistry {
    public AccountingRegistry(){
    }

    /*Updates AccountingRegistry and return the current Accounting value*/
    public double UpdateAccountingRegistry(double moneyEarned){
        double newAcc= GetAccounting() + moneyEarned;
        SetAccounting(newAcc);
        return newAcc;
    }
    private void SetAccounting(double newAccounting){
        //Contacts database and sets new Accounting Value
    }

    /*Instead of database*/
    private double GetAccounting(){
        return 1500;
    }
}
