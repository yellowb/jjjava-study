package week1.lesson5;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by HUANGYE2 on 11/14/2017.
 */
public class MyLongTest {

    @Test
    public void testMyLongEquals() {
        assertTrue("MyLong.equals() should be true.", new MyLong(1).equals(1));
    }

    @Test
    public void testLongEquals() {
        assertFalse("Long.equals() should be true.", new Long(1).equals(1));
    }




}
