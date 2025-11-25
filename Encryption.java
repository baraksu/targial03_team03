/**
 * Write a description of the class Encryption here.
 *
 * @author Yotam, Etan, Ariel
 * @version (a version number or a date)
 */
public class Encryption
{
    public static String replaceVowels(String str){
        str = str.replace('a','@');
        str = str.replace('e','#');
        str = str.replace('o','0');
        str = str.replace('u','&');
        str = str.replace('i','1');

        return str;
    }
    public static String replaceSpecialCharacter(String str){
        str = str.replace('@','a');
        str = str.replace('#','e');
        str = str.replace('0','o');
        str = str.replace('&','u');
        str = str.replace('1','i');

        return str;
    }
    
    public static void main(String[] args){
        
        System.out.println("Welcome to the Encryption / Decryption Program \nEnter 1 for Encrypt | 2 for Decrypt");
        int chose = reader.mextInt();
}
