package ModifyString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestModifyString {

    @Test
    void testModifyingStringSuccess(){
        String text = " hello world ";
        String result = ModifyString.modifyString(text);
        assertEquals("Helloworld", result);
    }

    @Test
    void testModifyingFirstCharIsNotLetter(){
        String input = "123 New world";
        Exception exception = assertThrows(Exception.class, () -> {
            ModifyString.modifyString(input);
        });

        String expectedMessage = "First char is not a letter";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testModifyStringNoSpaces(){
        String input = "goodbye";
        String result = ModifyString.modifyString(input);
        assertEquals("Goodbye", result);
    }

    public static void main(String[] args) {
        TestModifyString test = new TestModifyString();
        test.testModifyingFirstCharIsNotLetter();
        test.testModifyStringNoSpaces();
        test.testModifyingStringSuccess();
    }
}
