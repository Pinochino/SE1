package ArraySum;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class TestArraySum{

    @Test
    void arraySumTest_withValidArray() throws Exception {
        int[] arr = {1, 2, 3};
        assertEquals(6, ArraySum.arraySum(arr));
    }

    @Test
    void arraySumTest_withEmptyArray(){
        int[] emptyArray = {};
        Exception exception = assertThrows(Exception.class, () -> ArraySum.arraySum(emptyArray));
        assertEquals("Array is empty ", exception.getMessage());
    }

    @Test
    void testCalculateSum_withNullArray() {
        int[] nullArray = null;
        Exception exception = assertThrows(Exception.class, () -> ArraySum.arraySum(nullArray));
        assertEquals("Array is null", exception.getMessage());
    }

    @Test
    void testCalculateSum_withSingleElementArray() throws Exception {
        int[] array = {10};
        assertEquals(10, ArraySum.arraySum(array));
    }

    public static void main(String[] args) throws Exception {
       TestArraySum test = new TestArraySum();
       test.arraySumTest_withValidArray();
    }

//    static Stream<new Object> array() {
//        return Stream.of(
//                null, Exception, message: Array is null
//                new int[] {}
//
//        ); Exception, Array is empty
//    }
}
