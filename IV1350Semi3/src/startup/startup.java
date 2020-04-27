package startup;

import controller.Controller;
import dbHandler.*;
import view.View;
import java.util.ArrayList;

public class startup {
    public static void main(String args[]) throws Exception {
        String customerId = "1999-01-01-1234"; //personal number for a member

        RegistryCreator creator = new RegistryCreator(new CustomerRegistry(), new ItemRegistry (), new AccountingRegistry(), new InventoryRegistry());
            Controller contr = new Controller(creator);
            new View(contr).executions();
            Printer printer = new Printer();
    }
}
