package test;


import dbHandler.InventoryRegistry;
import model.DTO.ItemDTO;
import model.Sale;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

public class SaleTest {

    private Sale preMadeSaleForTest() {
        int itemId = 7;
        float VAT = 8;
        String name = "yogurt";
        double price = 13;
        ItemDTO item = new ItemDTO(itemId, VAT, name, price);
        Sale sale = new Sale();
        sale.addItem(item, 2);
        sale.addItem(item, 4);
        return sale;
    }

    @Test
    public void addItem(){
        int itemId = 7;
        float VAT = 8;
        String name = "yogurt";
        double price = 13;
        ItemDTO item = new ItemDTO(itemId, VAT, name, price);
        Sale sale = new Sale();
        try {
            sale.addItem(item, 2);
            sale.addItem(item, 4);
        }
        catch (Exception error){
            Assert.fail("Not possible to add items that doesnt exists in Inventory Registry or Item Registry");
        }

        ItemDTO itemInSale;
        int numberOfLoops = 0;
        for (ItemDTO i: sale.getAllItems()) {
            itemInSale = i;
            numberOfLoops++;
        }

        assertEquals("Adding the same item multiple times doesnt create duplicate item objects in sale", 1,numberOfLoops);
        assertEquals("Adding the same item multiple times doesnt affect the total price", 13*6, sale.getTotalPrice(), 0.0001);
        try {
            assertEquals((13 * 6) - 0.1, sale.getTotalPrice(), 0.0001);
            Assert.fail();
        }
        catch (Error error){}
        try {
            assertEquals((13*6)+0.1, sale.getTotalPrice(), 0.0001);
            Assert.fail();
        }
        catch (Error error){}

        sale.addItem(item, -7);
        assertEquals("Returning items to the store, and get money back",-13,sale.getTotalPrice(),0.0001);

    }
    /* TODO -> how do one compare out prints??
    @Test
    public void receiptTest() throws Exception {
        Sale sale = forTest();
        String expectedPrintout =
                "----------------------RECEIPT----------------------\n" +
                        "Best Store\n" +
                        "Adress 22, 123 45\n" +
                        "2020-04-20 13:56\n" +
                        "6.0x yogurt................... à 13.0.....78.0\n" +
                        "\n" +
                        " Total Price: 78.0\n" +
                        " Amount paid: 78.0\n" +
                        " Amout back: 0.0\n" +
                        "---------------------------------------------------"
                ;
        assertEquals("Checks if Receipt looks the way it should", System.out.print(expectedPrintout) , sale.payment(13*6));
    }
     */
    @Test
    public void paymentTest() throws Exception {
        Sale sale = preMadeSaleForTest();
        double changeIs0 = 13*6;
        double changeIs10 = (13*6)+10;
        double changeIsNotEnough = (13*6)-1;
        assertEquals(0,sale.payment(changeIs0),0.01);
        assertEquals(10,sale.payment(changeIs10),0.01);

        //tests if costumer pays too little Exception will be thrown
        //Should only pass if Exception is thrown
        try {
            sale.payment(changeIsNotEnough);
            Assert.fail("Expected to throw Exception");
        }
        catch (Exception expected){}

    }

    @Test
    public void updateTotalPriceTest(){
        Sale sale = preMadeSaleForTest();
        sale.updateTotalPrice(12.3);
        assertEquals("Testing discount", (13*6*(1-0.123)), sale.getTotalPrice(), 0.0001);
        sale.updateTotalPrice(100);
        assertEquals("If discount is 100% the price to pay is 0", 0, sale.getTotalPrice(), 0.0001);
    }
    @Test
    public void inventoryUpdateTest(){
        Sale sale = preMadeSaleForTest();
        InventoryRegistry inventoryRegistry = new InventoryRegistry();
        try {
            sale.inventoryUpdate();
            Assert.fail("Exception should be thrown since the item in sale doesnt exists in inventory register");
        } catch (Exception e) {}

        sale = new Sale();
        //
        sale.addItem((new ItemDTO(1, 12, "Apple", 12)),1);
        try {
            sale.inventoryUpdate();
        } catch (Exception e) {
            Assert.fail("Exception should not be thrown since the item in sale do exists in inventory register");
        }

        sale.addItem((new ItemDTO(1, 12, "Apple", 12)),199);
        try {
            sale.inventoryUpdate();
        } catch (Exception e) {
            Assert.fail("Quantity of an item in inventory register should ba able to be 0");
        }
        sale.addItem((new ItemDTO(1, 12, "Apple", 12)),1);
        try {
            sale.inventoryUpdate();
            Assert.fail("Exception should be thrown since the quantity of an item can't be negative in inventory register");
        } catch (Exception e) {}

    }

    public void accountingUpdate() {
        //TODO
    }

    public void getTotalPrice() {
        //TODO
    }

    public void getAmoutPaid() {
        //TODO
    }

    public void getChange() {
        //TODO
    }

    public void getAllItems() {
        //TODO
    }

}
