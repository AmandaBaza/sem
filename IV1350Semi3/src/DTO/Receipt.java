package DTO;

import printerHandler.Printer;
import model.Sale;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt {
    private Printer printer;
    /**Constructor**/
    public Receipt(){
        this.printer = new Printer();//connects to the printer
    }

    /**
     * Logic to create and print the receipt though the printer
     * @param sale contains all necessary information that's needed for the receipt
     */
    public void printReceipt (Sale sale) {
        String receipt = receipt(sale);
        printer.print(receipt);
    }

    private String receipt(Sale sale) {
        double totalPrice = sale.getTotalPrice();
        double amountPaid = sale.getAmoutPaid();
        double change = sale.getChange();
        double totalVAT = sale.getTotalVAT();
        double discount = sale.getDiscount();
        ItemDTO [] allItems = sale.getAllItems().toArray(new ItemDTO[0]);

        String receipt = "\n----------------------RECEIPT----------------------\n"+getStoreName()+ "\n"+getStoreAddress()+ "\n" +getDateAndTime()+ "\n";
        for (int i = 0; i < allItems.length; i++) {
            receipt = receipt + itemInReceipt(allItems[i])+ "\n";
        }
        if(discount !=0){
            receipt = receipt +"\n Discount: "+ discount+"%";
        }
        receipt = receipt + ("\n Total Price(inclusive moms): " + totalPrice + "\n VAT: " + totalVAT +"\n Amount paid: " +amountPaid+ "\n Amout back: "
                +change +"\n---------------------------------------------------\n");
        return receipt;
    }
    private String itemInReceipt(ItemDTO item) {
        double quantity =item.getItemQuantity();
        double priceIncludingVAT = item.getPrice() + item.getVAT();
        String itemAndPriceAsString = (quantity+"x "+ item.getName());
        itemAndPriceAsString += ("................... à " + priceIncludingVAT+ "....." + priceIncludingVAT*quantity);
        return itemAndPriceAsString;
    }

    /*Since there is no database for this information, these are pre set*/
    private String getStoreName(){
        return "Best Store";
    }
    private String getStoreAddress(){
        return "Adress 22, 123 45";
    }
    /*Time and date of the sale*/
    private String getDateAndTime(){
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime now = LocalDateTime.now();
        return dateTimeFormat.format(now);
    }
}
