package dbHandler;

import DTO.ItemDTO;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Amanda
 * tests for InvalidItemIdentifierExceptions
 */

public class InvalidItemIdentifierExceptionTest {
    private ItemRegistry itemReg = new ItemRegistry();
    ItemDTO nonExistingItem = new ItemDTO(3, 12, "Pear", 8);

    @Rule
    public ExpectedException expectedExc = ExpectedException.none();

    @Test
    public void testInvalidItemIdentifierExceptionThoughMethods() {
        try {
            itemReg.getItemInfo(nonExistingItem.getItemIdentifier());
            fail("Expected exception not thrown");
        }catch (DatabaseCanNotBeReachedException  | InvalidItemIdentifierException exc){
            assertTrue(exc instanceof InvalidItemIdentifierException);
        }
        try {
            itemReg.getItemSpecifications(nonExistingItem.getItemIdentifier(), nonExistingItem.getItemQuantity());
            fail("Expected exception not thrown");
        }catch (Exception exc){
            assertTrue(exc instanceof InvalidItemIdentifierException);
        }
    }

    @Test
    public void testInvalidItemIdentifierException() throws InvalidItemIdentifierException {
        ItemDTO[] list = {nonExistingItem};
        expectedExc.expect(InvalidItemIdentifierException.class);
        expectedExc.expectMessage("This item with identity number 5 does not exists");
        listTest(list, 5);
    }

    private void listTest(ItemDTO[] list, int id) throws InvalidItemIdentifierException {
        Boolean found=false;

        for (ItemDTO item : list){

            if (item.getItemIdentifier() == id) {
                found = true;
            }
        }
        if (!found)
            throw new InvalidItemIdentifierException(id);
    }

}