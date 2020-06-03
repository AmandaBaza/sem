package model;

/**
 *  Exception to throw when a Sale is not allowed to continue as it is
 */
public class SaleException extends Exception {
    public SaleException(String msg){
        super(msg);
    }
}
