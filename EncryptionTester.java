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
    @Test
    public void movingWords4(){
        String result4 = Encryption.movingWords("Yotam Ophir", 2);
        assertEquals("Ophir Yotam", result4);
    }
    @Test
    public void movingWords5(){
        String result5 = Encryption.movingWords("banana", 1);
        assertEquals("banana", result5);
    }
    
    @Test
    public void WordsCount1(){
        int result1 = Encryption.WordsCount("Yotam Ophir");
        assertEquals(2, result1);
    }
    @Test
    public void WordsCount2(){
        int result2 = Encryption.WordsCount("I love Givat Smuel");
        assertEquals(4, result2);
    }
    @Test
    public void WordsCount3(){
        int result3 = Encryption.WordsCount("computer");
        assertEquals(1, result3);
    }
    @Test
    public void WordsCount4(){
        int result4 = Encryption.WordsCount("How are you?");
        assertEquals(3, result4);
    }
    @Test
    public void WordsCount5(){
        int result5 = Encryption.WordsCount("I love to eat banana");
        assertEquals(5, result5);
    }
ce.replace('a','@');
        sentence = sentence.replace('e','#');
        sentence = sentence.replace('o','0');
        sentence = sentence.replace('u','&');
        sentence = sentence.replace('i','1');

    @Test
    public void replaceVowels1() {
        String actual = Encryption.replaceVowels("eitan");
        assertEquals("#1t@n", actual);
    }
    @Test
    public void replaceVowels2() {
        String actual = Encryption.replaceVowels("uads");
        assertEquals("&@ds", actual);
    }
    @Test
    public void replaceVowels3() {
        String actual = Encryption.replaceVowels("oded katsh");
        assertEquals("0d#d k@tsh", actual);
    }
    @Test
    public void replaceVowels4() {
        String actual = Encryption.replaceVowels("Eitan");
        assertEquals("E1t@n", actual);
    }
   @Test
    public void replaceVowels5() {
        String actual = Encryption.replaceVowels("IWEFHI");
        assertEquals("IWEFHI", actual);
    }
    

}
