package startup;

import controller.Controller;
import dbHandler.*;
import view.View;

public class startup {
    public static void main(String args[]) throws Exception {
        RegistryCreator creator = new RegistryCreator(new CustomerRegistry(), new ItemRegistry (), new AccountingRegistry(), new InventoryRegistry());
            Controller contr = new Controller(creator);
            new View(contr).executions();
    }
}
