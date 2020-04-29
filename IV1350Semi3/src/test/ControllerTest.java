package test;

import DTO.ItemDTO;
import controller.Controller;
import dbHandler.*;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ControllerTest {
    private Controller createContoller() throws Exception {
        RegistryCreator creator = new RegistryCreator(new CustomerRegistry(), new ItemRegistry(), new AccountingRegistry(), new InventoryRegistry());
        Controller contr = new Controller(creator);
        contr.startNewSale();
        return contr;
    }
    @Test
    public void callAddItemTest() throws Exception {
        Controller contr = createContoller();

        //Adding item with id that doesnt exist
        try {
            contr.callAddItem(7, 2);
            Assert.fail("Should not be possible to add items that doesnt exists");
        }
        catch (Exception e){
        }

        //Adding Item and checking it has the item returned has the same identifier
        ItemDTO item = contr.callAddItem(2, 5);
        assertEquals("the item returned has the same identifier as the one sent to callAddItem",2,item.getItemIdentifier());
        try {
            contr.callAddItem(2, -5);
        }catch (Exception e){
            Assert.fail();
        }
    }
    @Test
    public void totalPriceTest(){}

    @Test
    public void startPaymentTest() throws Exception {
        Controller contr = createContoller();
        contr.callAddItem(4, 2);
        String customerId = "2000-01-01-1230"; //personal number for a member
        contr.startPayment(customerId);
        assertEquals(35, contr.totalPrice(), 0.001);

        //new sale with a non member (has no discount)
        contr.startNewSale();
        contr.callAddItem(4, 2);
        contr.startPayment("2000-00-00-0000");
        assertEquals(70, contr.totalPrice(), 0.001);

    }
    @Test
    public void paymentTest() throws Exception {
        Controller contr = createContoller();
        contr.callAddItem(4, 3);
        assertEquals(0,contr.payment(105), 0.001);
        assertEquals(18.43,contr.payment(123.43), 0.001);
        assertEquals(0.0001,contr.payment(105.0001), 0.001);
        assertEquals(1.0001,contr.payment(106.0001), 0.001);
        assertEquals(0,contr.payment(105.0001), 0.001);
        assertEquals(1,contr.payment(106.0001), 0.001);
    }
}
