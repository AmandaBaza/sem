package dbHandler;

/**
 * Exception to throw when a database isn't reachable
 * it also prints out which database that is
 */
public class DatabaseCanNotBeReachedException extends Exception {
    public DatabaseCanNotBeReachedException(String registry){
        super("Database for "+registry+" can not be reached at the moment");
    }
}
