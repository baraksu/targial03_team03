/**
 * Write a description of the class Encryption here.
 *
 * @author Yotam, Etan, Ariel
 * @version (a version number or a date)
 */
public class Encryption
{
    // מחליף אותיות מיוחדות לסימנים                                                 
    public static String replaceVowels(String sentence){
        sentence = sentence.replace('a','@');
        sentence = sentence.replace('e','#');
        sentence = sentence.replace('o','0');
        sentence = sentence.replace('u','&');
        sentence = sentence.replace('i','1');

        return sentence;
        
    }
    // מחליף סימנים לאותיות מיוחדות
    public static String replaceSpecialCharacter(String sentence){
        sentence = sentence.replace('@','a');
        sentence = sentence.replace('#','e');
        sentence = sentence.replace('0','o');
        sentence = sentence.replace('&','u');
        sentence = sentence.replace('1','i');

        return sentence;
    //מזיז מילים פונקציה 2    
    }
    public static String MovingWords (String sentence, int words) {
    int firstSpace = sentence.indexOf(" ");
    int secondSpace = indexOf(" ", firstSpace);
    if (words == 2) {
        String word1 = sentence.substring(0, firstSpace);
        String word2 = sentence.substring(firstSpace + 1);
        sentence = word2 + " " + word1;
        return sentence;
    }
    if (words == 3) {
        String word1 = sentence.substring(0, firstSpace);
        String word2 = sentence.substring(firstSpace + 1, secondSpace);
        String word3 = sentence.substring(secondSpace + 1);
        sentence = word3 + " " + word1 + " " + word2;
        return sentence;
    }
}
    
    public static void main(String[] args){
        
        System.out.println("Welcome to the Encryption / Decryption Program \nEnter 1 for Encrypt | 2 for Decrypt");
        int chose = reader.mextInt();
}
