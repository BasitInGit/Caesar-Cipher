import java.util.HashMap;

public class MonoAlphaSubstitution extends Substitution{
    private HashMap<Character, Character> mapping = new HashMap<Character, Character>();
    private HashMap<Character, Character> mapping2 = new HashMap<Character, Character>();

    public MonoAlphaSubstitution() {
        for (char letter = 'a'; letter <= 'z'; letter++){
            mapping.put(letter, letter);
        }
    }

    public MonoAlphaSubstitution(String warp) {
        for (int i = 0; i < warp.length(); i+=2){
            mapping.put(warp.charAt(i), warp.charAt(i));
            mapping.put(warp.charAt(i+1), warp.charAt(i));
        }
        for (int i = 0; i < warp.length(); i+=2){
            mapping2.put(warp.charAt(i), warp.charAt(i));
            mapping2.put(warp.charAt(i), warp.charAt(i+1));
        }

    }

    public char encrypt(char ch){
        char newCh = mapping.get(ch);
        return newCh;
    }

    public char decrypt(char ch){
        char newCh = mapping2.get(ch);
        return newCh;
    }
    
    public static void main(String [] args) {
        Substitution alpha = new MonoAlphaSubstitution(args[1]);
        if (args[0] == "encrypt"){
            String crypt = alpha.encrypt(args[2]);
            System.out.println(crypt);
        }
        else if (args[0] == "decrypt"){
            String crypt = alpha.decrypt(args[2]);
            System.out.println(crypt);
        }
        
    }
}