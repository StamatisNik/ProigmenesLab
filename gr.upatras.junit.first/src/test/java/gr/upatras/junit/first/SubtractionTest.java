package gr.upatras.junit.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

class SubtractionTest {
    @Test
    void testExceptionIsThrown() {
        Subtraction tester = new Subtraction();
        assertThrows(IllegalArgumentException.class, () -> tester.subtract(1000, 5));
    }

    @Test
    void testSubtract() {
        Subtraction tester = new Subtraction();
        assertEquals("POSITIVE", tester.subtract(10, 5), "10 - 5 must be POSITIVE");
        assertEquals("NEGATIVE", tester.subtract(5, 10), "5 - 10 must be NEGATIVE ");
    }
}

