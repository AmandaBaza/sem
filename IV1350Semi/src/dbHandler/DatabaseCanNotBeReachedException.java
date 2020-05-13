package dbHandler;

public class DatabaseCanNotBeReachedException extends Exception {
    public DatabaseCanNotBeReachedException(String registry){
        super("Database for "+registry+" can not be reached at the moment");
    }
}
