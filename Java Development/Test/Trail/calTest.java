package Trail;
import org.junit.Test;
import static org.junit.Assert.*;

public class calTest{
    @Test
    public void addTest(){
        cal c = new cal(2,3);
        int result = c.add();
        int expected = 5;
        assertEquals(expected, result);

        cal c1 = new cal(-2,3);
        result = c1.add();
        expected = 1;
        assertEquals(expected, result);

        cal c2 = new cal(0,3);
        result = c2.add();
        expected = 3;
        assertEquals(expected, result);


    }
}