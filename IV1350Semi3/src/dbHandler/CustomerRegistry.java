package dbHandler;

import java.util.ArrayList;

public class CustomerRegistry {
    String customerId;
    double discount;

    public CustomerRegistry(){
    }

    public CustomerRegistry(String customerId, double discount){
        this.customerId = customerId;
        this.discount = discount;
    }

    /*Checks of the Customer is a member and if there is any discounts for them*/
    public double getCustomerDiscount(String customerId){
        for(CustomerRegistry customer: getAllCustomers()){
            if(customer.customerId.equals(customerId)) {
                return customer.discount;
            }
        }
        return 0;
    }

    public CustomerRegistry[] getAllCustomers(){
        String customerID1 = "1999-01-01-1234"; //personal number for a member
        String customerID2 = "1970-12-31-0000"; //personal number for a member
        String customerID3 = "1990-01-01-1234"; //personal number for a member
        String customerID4 = "2000-01-01-1234"; //personal number for a member
        String customerID5 = "2000-01-01-1230"; //personal number for a member

        CustomerRegistry cR1= new CustomerRegistry(customerID1,10);
        CustomerRegistry cR2= new CustomerRegistry(customerID5,50);
        CustomerRegistry cR3= new CustomerRegistry(customerID4,40);
        CustomerRegistry cR4= new CustomerRegistry(customerID3,30);
        CustomerRegistry cR5= new CustomerRegistry(customerID2,20);
        CustomerRegistry [] customers = {cR1,cR2,cR3,cR4,cR5};
        return customers;
    }


}

