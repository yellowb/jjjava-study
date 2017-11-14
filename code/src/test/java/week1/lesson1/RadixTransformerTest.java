package week1.lesson1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RadixTransformerTest {

    @Test
    public void test3To2() {
        assertEquals("Radix 3 convert to radix 2 not match.", "11001", RadixTransformer.transform("221", 3, 2));
    }

    @Test
    public void test2To3() {
        assertEquals("Radix 2 convert to radix 3 not match.", "221", RadixTransformer.transform("11001", 2, 3));
    }

}
