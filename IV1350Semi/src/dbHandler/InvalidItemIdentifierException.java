package dbHandler;


/**
 * TODO
 * Exception to throw when an item id isn't valid,
 * for example, an item with that id doesn't exist
 * @throws
 */
public class InvalidItemIdentifierException extends Exception {
    public InvalidItemIdentifierException(int itemid){
        super("This item with identity number " + itemid + " does not exists");
    }
}
