package dbHandler;

public class CustomerRegistry {
    String customerId;
    double discount;

    /**
     * Constructor
     */
    public CustomerRegistry(){
    }
    /**
     * Constructor where customer id and discount is set
     */
    public CustomerRegistry(String customerId, double discount){
        this.customerId = customerId;
        this.discount = discount;
    }

    /**
     * Checks of the Customer is a member and if there is any discounts for them
     * @param customerId used to identify customer
     * @return the discount, if they aren't a, member it returns 0 (as in 0% discount)
     */
    public double getCustomerDiscount(String customerId){
        for(CustomerRegistry customer: getAllCustomers()){
            if(customer.customerId.equals(customerId)) {
                return customer.discount;
            }
        }
        return 0;
    }

    /**Instead of database**/
    private CustomerRegistry[] getAllCustomers(){
        CustomerRegistry cR1= new CustomerRegistry("1999-01-01-1234",10);
        CustomerRegistry cR2= new CustomerRegistry("2000-01-01-1230",50);
        CustomerRegistry cR3= new CustomerRegistry("2000-01-01-1234",40);
        CustomerRegistry cR4= new CustomerRegistry("1990-01-01-1234",30);
        CustomerRegistry cR5= new CustomerRegistry("1970-12-31-0000",20);
        CustomerRegistry [] customers = {cR1,cR2,cR3,cR4,cR5};
        return customers;
    }


}

