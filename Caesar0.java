/**
 * A method for enrypting an decrypting texts using the caesar cipher 
 * 
 */
public class Caesar {
    private int shift = 12224;
    public Caesar (){}
    public Caesar (int key){
        shift+=key;
    }
    /**
     * Rotates a character by a given shift value.
     * 
     * 
     * 
     * This works by first checking whther the character is in upper or lower case
     * then shifting the character by as many places as the shift value.
     * 
     * The new chacter is returned in a char variable.
     * 
     * @param shift the amount by which the characted shoukd be shifted
     * @param c  the character to be rotated
     * @return  the rotated character
     */
    public static char rotate(int shift, char c) {

        char ch = ' ';
        if ((int)c >= 97 && (int)c <= 122) {
            int i = c - (int)'a';
            i = (i + shift) % 26;
            if (i < 0) {
                ch = (char)('{' + i);
            }
            else if (i >= 0) {
                ch = (char)('a' + i);
            }
            return ch;
            
        }
        else if ((int)c >= 65 && (int)c <= 90) {
            int i = c - (int)'A';
            i = (i + shift) % 26;
            if (i < 0){
                ch = (char)('[' + i);
            }
            else if ( i >= 0) {
                ch = (char)('A' + i);   
            }
            return ch;
        }
        else {
            return c;
        }

    }




    /**
     * Rotates a string by a given shift value.
     * 
     * 
     * 
     * This works by running th text by a loop that iterates the same amount of times
     * as the number of characters.
     * 
     * each time a character is taken and assigned to a method that rotates it by the 
     * given shift value.
     * 
     * The result is stored in a new string.
     *
     * @param shift the amount by which characters should be shifted.
     * @param chin the string text to be shifted
     * @return the new rotated text
     * 
     */
    public static String rotate(int shift, String chin) {
        String reChin = "";
        for (int i =0; i < chin.length(); i++) {
            reChin += rotate(shift, chin.charAt(i));
                
            
                
            }
        return reChin;
    }



    /**
     * The main method which accepts command line arguments to encrypt/decrypt a given string.
     *  the method also ensures it receives the right amount of arguements and complains otherwise.
     * 
     * @param args command line arguements delivering encrypted/decrypted text and shift key
     * 
     */
    public static void main(String [] args) {

        String words = "cipher text";
        String str1 = "encrypt";
        String str2 = "decrypt";

        if (args.length <= 2) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar encrypt n " +"\"" + words +"\"");
        } else if (args.length == 3) {
            Caesar beta = new Caesar(Integer.parseInt(args[1]));
            if (args[0] == "encrypt"){
                System.out.println(beta.rotate(shift, args[2]));
            }
            else if (args[0] == "decrypt"){
                System.out.println(beta.rotate(-shift, args[2]));
            }
            else {
                System.out.println("The first parameter must be " + "\"" + str1 + "\"" + " or " + "\"" + str2 + "\"" + "!");
                System.out.println("Usage: java Caesar encrypt n " +"\"" + words +"\"");
            }
        } else if (args.length> 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar encrypt n " +"\"" + words +"\"");
        }
    }
    
        String words = "cipher text";

        if (args.length <= 1) {
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar n " +"\"" + words +"\"");
        } else if (args.length == 2) {
            String crypt = rotate (Integer.parseInt(args[0]), args[1]);
            System.out.println(crypt);
        } else if (args.length> 2) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar n " +"\"" + words +"\"");
        }
    
    
}



