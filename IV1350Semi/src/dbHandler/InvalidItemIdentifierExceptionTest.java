package dbHandler;

import DTO.ItemDTO;
import org.junit.Rule;

import static org.junit.jupiter.api.Assertions.*;

class InvalidItemIdentifierExceptionTest {

    //getItemInfo
    //getItemSpecifications
    //inventoryUpdate

    @Rule

    public void a(){
        ItemDTO nonExistingItem = new ItemDTO(3, 12, "Pear", 8);
        try {
            getItemInfo(nonExistingItem.getItemIdentifier());
        }catch (InvalidItemIdentifierException exc){

        }
    }
}