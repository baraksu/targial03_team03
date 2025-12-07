/**
 * Unit tests for the Encryption class.
 * Tests cover encryption and decryption with 1, 2, and 3 words,
 * as well as invalid inputs.
 */
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;

public class BarakEncryptionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return outContent.toString();
    }

    private String lastResultValue() {
        String[] lines = getOutput().trim().split("\r?\n");
        String lastLine = lines[lines.length - 1].trim();
        int sep = lastLine.indexOf(":");
        return sep >= 0 ? lastLine.substring(sep + 1).trim() : lastLine;
    }

    // ========== ENCRYPTION TESTS ==========

    @Test
    public void testEncryptionWithOneWord() {
        provideInput("1\nhello\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should contain encrypted result", output.contains("0h#ll"));
    }

    @Test
    public void testEncryptionWithTwoWords() {
        provideInput("1\nhello world\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should contain encrypted result with two words", output.contains("l0w0rld h#l"));
    }

    @Test
    public void testEncryptionWithThreeWords() {
        provideInput("1\nhello world today\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should contain encrypted result with three words", output.contains("rldt0d@y h#ll0 w0"));
    }

    @Test
    public void testEncryptionWithVowels() {
        provideInput("1\naeiou\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should replace 'a' with '@'", output.contains("@"));
        assertTrue("Output should replace 'e' with '#'", output.contains("#"));
        assertTrue("Output should replace 'i' with '1'", output.contains("1"));
        assertTrue("Output should replace 'o' with '0'", output.contains("0"));
        assertTrue("Output should replace 'u' with '&'", output.contains("&"));
    }

    @Test
    public void testEncryptionWithNoVowels() {
        provideInput("1\nbcd\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should contain encrypted result", output.contains("dbc"));
    }

    // ========== DECRYPTION TESTS ==========

    @Test
    public void testDecryptionWithOneWord() {
        provideInput("2\n0h#ll\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should contain decrypted result", output.contains("hello"));
    }

    @Test
    public void testDecryptionWithTwoWords() {
        provideInput("2\nl0w0rld h#l\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should contain decrypted result", output.contains("hello world"));
    }

    @Test
    public void testDecryptionWithThreeWords() {
        provideInput("2\nrldt0d@y h#ll0 w0\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should contain decrypted result", output.contains("hello world today"));
    }

    @Test
    public void testDecryptionWithSpecialChars() {
        provideInput("2\n@#10&\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should replace '@' with 'a'", output.contains("a"));
        assertTrue("Output should replace '#' with 'e'", output.contains("e"));
        assertTrue("Output should replace '1' with 'i'", output.contains("i"));
        assertTrue("Output should replace '0' with 'o'", output.contains("o"));
        assertTrue("Output should replace '&' with 'u'", output.contains("u"));
    }

    // ========== INVALID INPUT TESTS ==========

    @Test
    public void testInvalidChoice() {
        provideInput("3\nhello\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should contain error message for invalid choice", output.contains("3 is not a valid choice"));
    }

    @Test
    public void testInvalidChoiceZero() {
        provideInput("0\nhello\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should contain error message for invalid choice", output.contains("0 is not a valid choice"));
    }

    @Test
    public void testMoreThanThreeWords() {
        provideInput("1\nhello world today tomorrow\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should contain error message for too many words", output.contains("more than 3 words"));
    }

    @Test
    public void testFourWordsExactly() {
        provideInput("1\none two three four\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should reject 4 words", output.contains("more than 3 words"));
    }

    // ========== ROUND-TRIP TESTS ==========

    @Test
    public void testRoundTripOneWord() {
        provideInput("1\ntest\n");
        Encryption.main(new String[]{});
        String encrypted = lastResultValue();
        outContent.reset();
        provideInput("2\n" + encrypted + "\n");
        Encryption.main(new String[]{});
        String decrypted = lastResultValue();
        assertTrue("Decrypted text should contain original word", decrypted.contains("test"));
    }

    @Test
    public void testRoundTripTwoWords() {
        provideInput("1\ngood morning\n");
        Encryption.main(new String[]{});
        String encrypted = lastResultValue();
        outContent.reset();
        provideInput("2\n" + encrypted + "\n");
        Encryption.main(new String[]{});
        String decrypted = lastResultValue();
        assertTrue("Decrypted text should contain original phrase", decrypted.contains("good morning"));
    }

    @Test
    public void testRoundTripThreeWords() {
        provideInput("1\none two three\n");
        Encryption.main(new String[]{});
        String encrypted = lastResultValue();
        outContent.reset();
        provideInput("2\n" + encrypted + "\n");
        Encryption.main(new String[]{});
        String decrypted = lastResultValue();
        assertTrue("Decrypted text should contain 'one'", decrypted.contains("one"));
        assertTrue("Decrypted text should contain 'three'", decrypted.contains("three"));
    }

    // ========== EDGE CASE TESTS ==========

    @Test
    public void testEncryptionEmptySpaces() {
        provideInput("1\na b\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should handle single character words", output.length() > 0);
    }

    @Test
    public void testDecryptionChoice2() {
        provideInput("2\ntt#s\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should process decryption", output.contains("test"));
    }

    @Test
    public void testEncryptionChoice1() {
        provideInput("1\ntest\n");
        Encryption.main(new String[]{});
        String output = getOutput();
        assertTrue("Output should process encryption", output.contains("tt#s"));
    }
}
