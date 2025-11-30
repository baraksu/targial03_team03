import java.util.Scanner;
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
    }

        // הזזת אותיות פונקציה  1
    public static String movingCharacters(String sentence, int words){
        int len = sentence.length();
        if (words == 1){
            String lastchar = sentence.substring(len - 1);
            String restofcharacters = sentence.substring(0, len - 1);
            sentence = lastchar + restofcharacters;
        }
        else if (words == 2){
            String lasttwocharacters = sentence.substring(len - 2);
            String restofcharacters = sentence.substring(0, len - 2);
            sentence = lasttwocharacters + restofcharacters;
        }
        else if (words == 3){
            String lastthreecharacters = sentence.substring(len - 3);
            String restofcharacters = sentence.substring(0, len - 3);
            sentence = lastthreecharacters + restofcharacters;
        }
        return sentence;
    }
    
    // הזזת אותיות פונקציה 2
    public static String movingCharactersBack(String sentence, int words){
        if (words == 1){
            String lastchar = sentence.substring(0, 1);
            String restofcharacters = sentence.substring(1);
            sentence = restofcharacters + lastchar;
        }
        else if (words == 2){
            String lasttwocharacters = sentence.substring(0, 2);
            String restofcharacters = sentence.substring(2);
            sentence = restofcharacters + lasttwocharacters;
        }
        else if (words == 3){
            String lastthreecharacters = sentence.substring(0, 3);
            String restofcharacters = sentence.substring(3);
            sentence = restofcharacters + lastthreecharacters;
        }
        return sentence;
    }

    //מזיז מילים פונקציה 2    
    public static String movingWords (String sentence, int words) {
    int firstSpace = sentence.indexOf(" ");
    int secondSpace = sentence.indexOf(" ", firstSpace + 1);
    if (words == 2) {
        String word1 = sentence.substring(0, firstSpace);
        String word2 = sentence.substring(firstSpace + 1);
        sentence = word2 + " " + word1;
    }
    if (words == 3) {
        String word1 = sentence.substring(0, firstSpace);
        String word2 = sentence.substring(firstSpace + 1, secondSpace);
        String word3 = sentence.substring(secondSpace + 1);
        sentence = word3 + " " + word1 + " " + word2;
    }
    return sentence;
    }
    
    public static String movingWordsBack (String sentence, int words) {
    int firstSpace = sentence.indexOf(" ");
    int secondSpace = sentence.indexOf(" ", firstSpace + 1);
    if (words == 2) {
        String word2 = sentence.substring(0, firstSpace);
        String word1 = sentence.substring(firstSpace + 1);
        sentence = word1 + " " + word2;
    }
    if (words == 3) {
        String word3 = sentence.substring(0, firstSpace);
        String word1 = sentence.substring(firstSpace + 1, secondSpace);
        String word2 = sentence.substring(secondSpace + 1);
        sentence = word1 + " " + word2 + " " + word3;
    }
    return sentence;
    }
//   בודק כמה מילים יש
    public static int wordsCount(String sentence) {
        int originalLength = sentence.length(); 
        String withoutSpaces = sentence.replaceAll(" ", "");
        int withoutSpacesLenght = withoutSpaces.length();
        int words = originalLength - withoutSpacesLenght + 1;
        return words;
    }
    
// פונקצייה ראשית
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to the Encryption / Decryption Program \nEnter 1 for Encrypt | 2 for Decrypt");
        int choice = reader.nextInt();
        reader.nextLine();
        if (choice == 1) {
                System.out.println("Enter up to 3 words sentence");
                String sentence  = reader.nextLine();
                int words = wordsCount(sentence);
                if (words > 3)
                    System.out.println(sentence + " contains more than 3 words");
                else {
                    sentence = movingWords(sentence, words);
                    sentence = movingCharacters(sentence, words);
                    sentence = replaceVowels(sentence);
                    System.out.println("The encrypted sentence: " + sentence);
                }
        }
        else if (choice == 2) {
                System.out.println("Enter up to 3 words sentence");
                String sentence  = reader.nextLine();
                int words = wordsCount(sentence);
                if (words > 3)
                    System.out.println(sentence + " contains more than 3 words");
                else {
                    sentence = replaceSpecialCharacter(sentence);
                    sentence = movingCharactersBack(sentence, words);
                    sentence = movingWordsBack(sentence, words);
                    System.out.println("The decrypted sentence: " + sentence);
                }
        }
        else {
            System.out.println (choice + "is not a valid choice");
            return;
        }
        
    }
}
