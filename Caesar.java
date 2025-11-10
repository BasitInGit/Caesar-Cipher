public class Caesar extends MonoAlphaSubstitution {
    private int shift;                    //takes encryption key
    public Caesar (){}
    public Caesar (int key){shift=key + 12224 % 26; }                //consturctor updates shift value

    public char encrypt(char c) {
        char ch = ' ';
        if ((int)c >= 97 && (int)c <= 122) {        // if statement to ensure only lowercase letters
            int i = c - (int)'a';                    
            i = (i + shift) % 26;                    // encrypts character by (shift) value
            if (i < 0) {
                ch = (char)('{' + i); }
            else if (i >= 0) {
                ch = (char)('a' + i); }
            return ch; }

        else if ((int)c >= 65 && (int)c <= 90) {             //if statement to ensure only uppercase letters
            int i = c - (int)'A';
            i = (i + shift) % 26;
            if (i < 0){
                ch = (char)('[' + i); }
            else if ( i >= 0) {
                ch = (char)('A' + i); }
            return ch; }

        else {
            return c;
        }}

    public char decrypt(char c) {          //follows similar rules as encryption
        char ch = ' ';
        if ((int)c >= 97 && (int)c <= 122) {
            int i = c - (int)'a';
            i = (i - shift) % 26;
            if (i < 0) {
                ch = (char)('{' + i); }
            else if (i >= 0) {
                ch = (char)('a' + i); }
            return ch; }

        else if ((int)c >= 65 && (int)c <= 90) {
            int i = c - (int)'A';
            i = (i - shift) % 26;
            if (i < 0){
                ch = (char)('[' + i); }
            else if ( i >= 0) {
                ch = (char)('A' + i); }
            return ch; }

        else {
            return c;
        }}

    public static void main(String [] args) {                          
        String words = "cipher text";
        String str1 = "encrypt";
        String str2 = "decrypt";

        if (args.length <= 2) {                 //if statement ensures user enters the right amount of arguemnts
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Caesar encrypt n " +"\"" + words +"\"");
        } else if (args.length == 3) {
            Caesar beta = new Caesar(Integer.parseInt(args[1]));
            if (args[0].equals("encrypt")){                    //nested if statement to check whether to encrypt or decrypt and also ensures whether user enters either
                System.out.println(beta.encrypt(args[2]));
            }
            else if (args[0].equals("decrypt")){
                System.out.println(beta.decrypt(args[2]));
            }
            else {
                System.out.println("The first parameter must be " + "\"" + str1 + "\"" + " or " + "\"" + str2 + "\"" + "!");
                System.out.println("Usage: java Caesar encrypt n " +"\"" + words +"\"");
            }
        } else if (args.length> 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Caesar encrypt n " +"\"" + words +"\"");
        }} 
}



