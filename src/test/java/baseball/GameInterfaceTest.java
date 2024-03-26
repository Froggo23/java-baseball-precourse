package baseball;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameInterfaceTest {

    private final InputStream originalIn = System.in;
    private GameInterface gameInterface;

    @BeforeEach
    public void setUp() {
        gameInterface = new GameInterface();
    }

    @AfterEach
    public void restoreSystemIn() {
        System.setIn(originalIn);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    public void testGetGuessWithValidInput() {
        // Simulate user input "354"
        provideInput("354");

        // Call the method under test
        gameInterface.getGuess();

        // Assert that the guess list correctly contains {3, 5, 4}
        assertEquals(Arrays.asList(3, 5, 4), gameInterface.guess, "The guess list should contain [3, 5, 4]");
    }

    @Test
    public void testGetGuessWithInvalidInput() {
        // Simulate user input "1234" (invalid because we expect exactly 3 digits)
        provideInput("1234");

        try {
            // Attempt to call the method that should throw an exception
            gameInterface.getGuess();
            // If the method call above does not throw an exception, fail the test
            fail("Expected IllegalArgumentException to be thrown for invalid input");
        } catch (IllegalArgumentException e) {
            // If an IllegalArgumentException is caught, the test passes, so we assert true
            // Optionally, you can assert details about the exception message if needed
            assertTrue(e.getMessage().contains("Input must be exactly 3 digits."));
        } catch (Throwable t) {
            // If any other type of exception is thrown, fail the test
            fail("Expected IllegalArgumentException, but caught different exception");
        }
    }


}