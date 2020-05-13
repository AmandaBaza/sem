package view;

import controller.Controller;
import DTO.ItemDTO;
import dbHandler.InvalidItemIdentifierException;

public class View {
    private Controller contr;
    int itemIdentifiers [] = {1,3,4};
    int itemQuantity [] = {1,2,10};
    String customerID = "1999-01-01-1234"; //the customers personal number
    double cash = 415;

    public View(Controller contr) {
        this.contr = contr;
    }

    public void executions() throws Exception {
            /**User starts new sale **/
            contr.startNewSale();
            /**
             * User enters item identifier and program returns the
             * item object (ItemDTO),
             * which contains all information about the item.
             * Program records the sold item though callAddItem
             * (that calls add item in controller).
             * Program return and shows the items
             * price, and running total (including VAT).
             **/
            double totalPrice = 0;
            for (int i = 0; i < itemIdentifiers.length; i++) {
                try {
                    //the user can choose how many of the same item to add
                    ItemDTO itemSpecification = contr.callAddItem(itemIdentifiers[i], itemQuantity[i]);

                    String displayScanningMessage;
                    if (itemSpecification != null) {
                        displayScanningMessage = ("Name:" + itemSpecification.getName() +"\nQuantity:" + itemSpecification.getItemQuantity()+ "\nPrice:" + itemSpecification.getPrice() + "\nVAT:" +itemSpecification.getVAT());
                    } else
                        displayScanningMessage = new String("Item not found");
                    System.out.println("Display message:\n"+displayScanningMessage);
                    totalPrice = contr.totalPrice();
                    System.out.println("Total price:" + totalPrice+"\n");
                }
                catch(InvalidItemIdentifierException e){
                    System.out.println("This item with identity number" + itemIdentifiers[i] + " does not exist. Try again or continue\n");
                }
            }
            //All items are now registered, sale is now ended and Payment will start
            contr.startPayment(customerID);
            double change = contr.payment(cash);
        System.out.println("\nTotal price:"+ contr.totalPrice());
            System.out.println("Money paid:" + cash);
            System.out.println("Money back:" + change);

    }
}
