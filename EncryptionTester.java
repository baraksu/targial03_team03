import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Write a description of class EncryptionTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EncryptionTester
{
    @Test
    public void movingWords1(){
        String result = Encryption.movingWords("ax vf",2);
        assertEquals("vf ax",result);
    }
    @Test
    public void movingWords2(){
        String result2 = Encryption.movingWords("ax vf ht", 3);
        assertEquals("ht ax vf",result2);
    }
    @Test
    public void movingWords3(){
        String result3 = Encryption.movingWords("how are you?", 3);
        assertEquals("you? how are", result3);
    }
}
