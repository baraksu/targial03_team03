import static org.junit.Assert.*;
import org.junit.Test;


/**
 * Write a description of class EncryptionTester here.
 *
 * @author (Ariel, Eitan, Yotam)
 * @version (1.0 (30.11.2025)
 */
public class EncryptionTester
{

    // בודק את מזיז המילים
    // Yotam
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

    // בודק את סופר המילים
    // Yotam
    @Test
    public void wordsCount1(){
        int result1 = Encryption.wordsCount("Yotam Ophir");
        assertEquals(2, result1);
    }
    @Test
    public void wordsCount2(){
        int result2 = Encryption.wordsCount("I love Givat Smuel");
        assertEquals(4, result2);
    }
    @Test
    public void wordsCount3(){
        int result3 = Encryption.wordsCount("computer");
        assertEquals(1, result3);
    }
    @Test
    public void wordsCount4(){
        int result4 = Encryption.wordsCount("How are you?");
        assertEquals(3, result4);
    }
    @Test
    public void wordsCount5(){
        int result5 = Encryption.wordsCount("I love to eat banana");
        assertEquals(5, result5);
    }

    // בודק את מחליף התווים
    // Eitan
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
        String actual = Encryption.replaceVowels("oded katash");
        assertEquals("0d#d k@t@sh", actual);
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

    // בודק את מחזיר התווים
    // Eitan
    @Test
    public void replaceSpecialCharacter1() {
        String actual = Encryption.replaceSpecialCharacter("#1t@n");
        assertEquals("eitan", actual);
    }
    @Test
    public void replaceSpecialCharacter2() {
        String actual = Encryption.replaceSpecialCharacter("&@ds");
        assertEquals("uads", actual);
    }
    @Test
    public void replaceSpecialCharacter3() {
        String actual = Encryption.replaceSpecialCharacter("0d#d k@t@sh");
        assertEquals("oded katash", actual);
    }
    @Test
    public void replaceSpecialCharacter4() {
        String actual = Encryption.replaceSpecialCharacter("E1t@n");
        assertEquals("Eitan", actual);
    }
    @Test
    public void replaceSpecialCharacter5() {
        String actual = Encryption.replaceSpecialCharacter("IWEFHI");
        assertEquals("IWEFHI", actual);
    }

    // בודק את מזיז האותיות
    // Ariel
    @Test
    public void movingCharacters1() {
        String result1 = Encryption.movingCharacters("ariel", 1);
        assertEquals("larie", result1);
    }
    @Test
    public void movingCharacters2() {
        String result2 = Encryption.movingCharacters("banana", 1);
        assertEquals("abanan", result2);
    }
    @Test
    public void movingCharacters3() {
        String result3 = Encryption.movingCharacters("banani vebanoni", 2);
        assertEquals("nibanani vebano", result3);
    }
    @Test
    public void movingCharacters4() {
        String result4 = Encryption.movingCharacters("shabat shalom", 2);
        assertEquals("omshabat shal", result4);
    }
    @Test
    public void movingCharacters5() {
        String result5 = Encryption.movingCharacters("ariel the goat", 3);
        assertEquals("oatariel the g", result5);
    }
    @Test
    public void movingCharacters6() {
        String result6 = Encryption.movingCharacters("abcd efgh ijkl", 3);
        assertEquals("jklabcd efgh i", result6);
    }

    // בודק את מזיז האותיות בחזרה
    // Ariel
    @Test
    public void movingCharactersBack1() {
        String result1 = Encryption.movingCharactersBack("larie", 1);
        assertEquals("ariel", result1);
    }
    @Test
    public void movingCharactersBack2() {
        String result2 = Encryption.movingCharactersBack("abanan", 1);
        assertEquals("banana", result2);
    }
    @Test
    public void movingCharactersBack3() {
        String result3 = Encryption.movingCharactersBack("nibanani vebano", 2);
        assertEquals("banani vebanoni", result3);
    }
    @Test
    public void movingCharactersBack4() {
        String result4 = Encryption.movingCharactersBack("omshabat shal", 2);
        assertEquals("shabat shalom", result4);
    }
    @Test
    public void movingCharactersBack5() {
        String result5 = Encryption.movingCharactersBack("oatariel the g", 3);
        assertEquals("ariel the goat", result5);
    }
    @Test
    public void movingCharactersBack6() {
        String result6 = Encryption.movingCharactersBack("jklabcd efgh i", 3);
        assertEquals("abcd efgh ijkl", result6);
    }

    // בודק את מזיז המילים בחזרה
    // Ariel
    @Test
    public void movingWordsBack1() {
        String result1 = Encryption.movingWordsBack("abcd", 1);
        assertEquals("abcd", result1);
    }
    @Test
    public void movingWordsBack2() {
        String result2 = Encryption.movingWordsBack("ophir yotam", 2);
        assertEquals("yotam ophir", result2);
    }
    @Test
    public void movingWordsBack3() {
        String result3 = Encryption.movingWordsBack("banani vebanoni", 2);
        assertEquals("vebanoni banani", result3);
    }
    @Test
    public void movingWordsBack4() {
        String result4 = Encryption.movingWordsBack("I love pizza", 3);
        assertEquals("love pizza I", result4);
    }
    @Test
    public void movingWordsBack5() {
        String result5 = Encryption.movingWordsBack("mevorach shabat shalom", 3);
        assertEquals("shabat shalom mevorach", result5);
    }
}
