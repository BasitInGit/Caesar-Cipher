import java.util.HashMap;

public class MonoAlphaSubstitution extends Substitution{
    private HashMap<Character, Character> mapping = new HashMap<Character, Character>();    
    private HashMap<Character, Character> mapping2 = new HashMap<Character, Character>();  //reverse mapping for decryption

    public MonoAlphaSubstitution() {
        for (char letter = 'a'; letter <= 'z'; letter++){
            mapping.put(letter, letter);                   //maps each letter to itself
        }
    }

    public MonoAlphaSubstitution(String s) {
        int i = 0;
        while (i<s.length()){                           //maps even lowercase characters to the character ahead and odd uppercase case characters to the character behind it
            if (Character.isUpperCase(s.charAt(i))==false){
                mapping.put(s.charAt(i+1), s.charAt(i));
                mapping2.put(s.charAt(i), s.charAt(i+1));
            }
            i++;
            if (Character.isUpperCase(s.charAt(i))==true){
                mapping.put(s.charAt(i-1), s.charAt(i));
                mapping2.put(s.charAt(i), s.charAt(i-1));
            }
            i++;
        }
    }

    public char encrypt(char ch){                 //checks if arguement character exists in (mapping) and if so obtains the value assigned   
        if (mapping.containsKey(ch)== true){
            char newCh = mapping.get(ch);
            return newCh;
        }
        else {                                 //if character doesn't exist, it gets returned without encryption
            return ch;
        }
    }

    public char decrypt(char ch){                //follows the same rules as encryption
        if (mapping2.containsKey(ch)== true){
            char newCh = mapping2.get(ch);
            return newCh;
        }
        else {
            return ch;
        }
    }
    
    public static void main(String [] args) {
        String words = "cipher text";
        String str1 = "encrypt";
        String str2 = "decrypt";
        if (args.length <= 2) {                                //if statement ensures user enters the right amount of arguemnts
            System.out.println("Too few parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key " +"\"" + words +"\"");
        } else if (args.length == 3) {

            MonoAlphaSubstitution alpha = new MonoAlphaSubstitution(args[1]);
            if (args[0].equals("encrypt")){                                //nested if statement to check whether to encrypt or decrypt and also ensures whether user enters either
                System.out.println(alpha.encrypt(args[2]));
            }
            else if (args[0].equals("decrypt")){
                System.out.println(alpha.decrypt(args[2]));
            }
            else {
                System.out.println("The first parameter must be " + "\"" + str1 + "\"" + " or " + "\"" + str2 + "\"" + "!");
                System.out.println("Usage: java MonoAlphaSubstitution encrypt key " +"\"" + words +"\"");
            }

        } else if (args.length> 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java MonoAlphaSubstitution encrypt key " +"\"" + words +"\"");
        }}
}