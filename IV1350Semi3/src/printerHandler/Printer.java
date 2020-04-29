package printerHandler;

public class Printer {
    /*Constructor*/
    public Printer(){
    }
    /**Connects to printer to print out the receipt.
     Since there is no actual printer will it
     just print it in the terminal.**/
    public void print (String receiptToPrint) {
        System.out.println (receiptToPrint);
    }

}
