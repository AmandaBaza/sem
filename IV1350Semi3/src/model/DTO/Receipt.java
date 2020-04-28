package model.DTO;

import dbHandler.Printer;
import model.Sale;

import java.security.PublicKey;

public class Receipt {

    private String storeName = "Best Store";
    private String storeAdress = "Adress 22, 123 45";
    private String dateAndTime = "2020-04-20 13:56";

    private Printer printer;
    /*Constructor*/
    public Receipt(){
        printer = new Printer();
    }

    private String receipt(Sale sale) {
        double totalPrice = sale.getTotalPrice();
        double amountPaid = sale.getAmoutPaid();
        double change = sale.getChange();
        ItemDTO [] allItems = sale.getAllItems().toArray(new ItemDTO[0]);

        String receipt = "\n----------------------RECEIPT----------------------\n"+storeName+ "\n"+storeAdress+ "\n" +dateAndTime+ "\n";
        for (int i = 0; i < allItems.length; i++) {
            receipt = receipt + itemToString(allItems[i])+ "\n";
        }
        receipt = receipt + ("\n Total Price: " +totalPrice+ "\n Amout paid: " +amountPaid+ "\n Amout back: " +change
                +"\n---------------------------------------------------\n");
        return receipt;
    }
    private String itemToString(ItemDTO item) {
        double quantity =item.getItemQuantity();
        double price = item.getPrice();
        String itemAndPriceAsString = (quantity+"x "+ item.getName());
        itemAndPriceAsString += ("................... à " + price+ "....." + price*quantity);
        return itemAndPriceAsString;
    }

    public void printReceipt (Sale sale) {
        String receipt = receipt(sale);
        printer.print(receipt);
    }

}
