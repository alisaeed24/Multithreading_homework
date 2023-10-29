package org.example;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class PrimeNumbersServiceTest extends TestCase {
    @Test
    public void testThreeIsPrime(){
        PrimeNumbersService test = new PrimeNumbersService();
        assertTrue(test.isPrimeNumber(3));
    }
    @Test
    public void testFindPrimeNumbersFromOneToTen(){
        PrimeNumbersService test = new PrimeNumbersService(0,10);
        List<Integer> expected = Arrays.asList(2, 3, 5, 7);

        assertEquals(expected,test.findPrimeNumbers());

    }
}