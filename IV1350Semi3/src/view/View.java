package view;

import controller.Controller;
import model.DTO.ItemDTO;

public class View {
    private Controller contr;
    int itemIdentifiers [] = {4,1,2,4,3};
    int itemQuantity [] = {3,1,2,2,10};
    String customerID = "1999-01-01-1234"; //the customers personal number
    double cash = 215;

    public View(Controller contr) {
        this.contr = contr;
    }

    public void executions() throws Exception {
        /**User starts new sale **/
        contr.startNewSale();
        /**
         * User enters item identifier Program returns the
         * item object (ItemDTO),
         * which contains all information about the item.
         * Program records the sold item though callAddItem
         * (that calls add item in controller).
         * Program return and shows the items
         * price, and running total (including VAT).
        **/
        double totalPrice = 0;
        for (int i = 0; i < itemIdentifiers.length; i++) {
            //the user can choose how many of the same item to add
            ItemDTO itemSpecification = contr.callAddItem(itemIdentifiers[i], itemQuantity[i]);

            String displayScanningMessage;
            if (itemSpecification != null) {
                displayScanningMessage = ("Name:" + contr.callGetName(itemSpecification) + "\nPrice:" + contr.callGetPrice(itemSpecification));
            } else
                displayScanningMessage = new String("Item not found");
            System.out.println (displayScanningMessage);
            totalPrice = contr.totalPrice();
            System.out.println("Total price:"+totalPrice);
        }
        contr.startPayment(customerID);
        double change = contr.payment(cash);
        System.out.println ("Money paid:" + cash);
        System.out.println ("Money back:" + change);
    }
}
/*************** Out print **************************
 Name:Orange
 Price:10.0
 Total price:30.0
 Name:Apple
 Price:12.0
 Total price:42.0
 Name:Banana
 Price:9.0
 Total price:60.0
 Name:Orange
 Price:10.0
 Total price:80.0
 Name:Pear
 Price:8.0
 Total price:160.0

 ----------------------RECEIPT----------------------
 Best Store
 Adress 22, 123 45
 2020-04-20 13:56
 5.0x Orange................... à 10.0.....50.0
 1.0x Apple................... à 12.0.....12.0
 2.0x Banana................... à 9.0.....18.0
 10.0x Pear................... à 8.0.....80.0

 Total Price: 144.0
 Amount paid: 215.0
 Amout back: 71.0
 ---------------------------------------------------

 Money paid:215.0
 Money back:71.0

 ****************************************************/
