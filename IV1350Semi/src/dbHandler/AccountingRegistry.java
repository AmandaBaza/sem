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
    public double UpdateAccountingRegistry(double moneyToAccount) throws DatabaseCanNotBeReachedException {
       double accounting = GetAccounting();
       if(accounting < 0){
           System.out.println("\nLOGGER: Cannot call Accounting Registry database");
           throw new DatabaseCanNotBeReachedException("Accounting Registry");
       }
        double newAcc= accounting + moneyToAccount;
        SetAccounting(newAcc);
        return newAcc;
    }
    private void SetAccounting(double newAccounting){
        //Contacts database and sets new Accounting Value
    }

    /**calls to database, instead of database it's manually added**/
    private double GetAccounting(){
        return 1500;

        //manual representation if database cannot be reached
        //return -1;
    }
}
