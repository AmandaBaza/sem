package dbHandler;

public class AccountingRegistry {
    /**
     * Constructor
     */
    public AccountingRegistry(){
    }
    /**
     * Updates AccountingRegistry
     * @param moneyToAccount how much to add (or remove if it's negative) to the Accounting Registry
     * @return the current Accounting value
     */
    public double UpdateAccountingRegistry(double moneyToAccount){
        double newAcc= GetAccounting() + moneyToAccount;
        SetAccounting(newAcc);
        return newAcc;
    }
    private void SetAccounting(double newAccounting){
        //Contacts database and sets new Accounting Value
    }

    /**calls to database, instead of database it's manually added**/
    private double GetAccounting(){
        return 1500;
    }
}
