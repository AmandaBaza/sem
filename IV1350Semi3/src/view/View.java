package view;

import controller.Controller;
import DTO.ItemDTO;

public class View {
    private Controller contr;
    int itemIdentifiers [] = {4,1,2,4,3};
    int itemQuantity [] = {3,1,2,2,10};
    String customerID = "1999-01-01-1234"; //the customers personal number
    double cash = 415;

    public View(Controller contr) {
        this.contr = contr;
    }

    public void executions() throws Exception {
        try {

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
            //All items are now registered, sale is now ended and Payment will start
            contr.startPayment(customerID);
            double change = contr.payment(cash);
        System.out.println("Total price:"+ contr.totalPrice());
            System.out.println("Money paid:" + cash);
            System.out.println("Money back:" + change);
        }catch (Exception e){
            System.out.println("Exception has occurred");
        }
    }
}
/*************** Out print **************************
 Display message:
 Name:Orange
 Quantity:3
 Price:10.0
 VAT:25
 Total price:105.0

 Display message:
 Name:Apple
 Quantity:1
 Price:12.0
 VAT:12
 Total price:129.0

 Display message:
 Name:Banana
 Quantity:2
 Price:9.0
 VAT:6
 Total price:159.0

 Display message:
 Name:Orange
 Quantity:2
 Price:10.0
 VAT:25
 Total price:229.0

 Display message:
 Name:Pear
 Quantity:10
 Price:8.0
 VAT:12
 Total price:429.0


 ----------------------RECEIPT----------------------
 Best Store
 Adress 22, 123 45
 2020-04-29 17:16
 5.0x Orange................... à 35.0.....175.0
 1.0x Apple................... à 24.0.....24.0
 2.0x Banana................... à 15.0.....30.0
 10.0x Pear................... à 20.0.....200.0

 Discount: 10.0%
 Total Price(inclusive moms): 386.1
 VAT: 269.0
 Amount paid: 415.0
 Amout back: 28.9
 ---------------------------------------------------

 Total price:386.1
 Money paid:415.0
 Money back:28.9

 ****************************************************/
