package dbHandler;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Amanda
 */
public class DatabaseCanNotBeReachedExceptionTest {

    @Rule
    public ExpectedException expectedExc = ExpectedException.none();

    @Test
    public void testDatabaseCanNotBeReachedException() throws DatabaseCanNotBeReachedException {
        expectedExc.expect(DatabaseCanNotBeReachedException.class);
        expectedExc.expectMessage("Test for DatabaseCanNotBeReachedException");
        test(-1);
    }

    private void test(int id) throws DatabaseCanNotBeReachedException {
        if(id==-1){
            throw new DatabaseCanNotBeReachedException("Test for DatabaseCanNotBeReachedException");
        }else {

        }
    }


}