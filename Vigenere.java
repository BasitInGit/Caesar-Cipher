import java.util.HashMap;
public class Vigenere extends Substitution{
    Caesar [] store;
    private int index = 0;             // Index is used to tell me how far through the Caesar ciphers in 'store' I am
    
    public Vigenere(){}
    public Vigenere(String key){        
        store = new Caesar[key.length()];        //instantiates the store array with objects the size of the string arguement length
        for (int i = 0; i < key.length(); i++){         //loop to extract integer value of each character 
            char c = key.charAt(i);
            int j = c - (int)'A';
            store[i] = new Caesar(j-4);                 //integer values used to create different caesars and stores in array (store) according to their order
        }}

    public char encrypt(char ch){        // encrypt char gets called from the method (encrypt string)inherited from substitution superclass
        Caesar c = store[index];           
        char encrypted = c.encrypt(ch);        
        index++;                           //class attribute index increases by 1 each time the method is called
        index = index % store.length;       //ensures that index doesn't increase beyond (store.length) and loops the same numbers if it does exceed
        return encrypted;  
    }

    public char decrypt(char ch){        //follows the same rules as encryption
        Caesar c = store[index];
        char decrypted = c.decrypt(ch);
        index++;
        index = index % store.length;
        return decrypted;
    }

    public static void main(String[] args) {
        String words = "cipher text";
        String str1 = "encrypt";
        String str2 = "decrypt";
        if (args.length <= 2) {                         //if statement ensures user enters the right amount of arguemnts
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Vigenere encrypt key " +"\"" + words +"\"");
        } else if (args.length == 3) {

            Vigenere gamma = new Vigenere (args[1]);
            if (args[0].equals("encrypt")){                   //nested if statement to check whether to encrypt or decrypt and also ensures whether user enters either
                System.out.println(gamma.encrypt(args[2]));
            }
            else if (args[0].equals("decrypt")){
                System.out.println(gamma.decrypt(args[2]));
            }
            else {
                System.out.println("The first parameter must be " + "\"" + str1 + "\"" + " or " + "\"" + str2 + "\"" + "!");
                System.out.println("Usage: java Vigenere encrypt key " +"\"" + words +"\"");
            }

        } else if (args.length> 3) {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Vigenere encrypt key " +"\"" + words +"\"");
        }}
}