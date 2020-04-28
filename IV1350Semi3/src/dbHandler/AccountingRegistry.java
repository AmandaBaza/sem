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
    /*Returns A solid value since there is no database*/
    private double GetAccounting(){
        return 1500;
    }
    private void SetAccounting(double newAccounting){
        //Contacts database and sends new Accounting Value
    }

}
