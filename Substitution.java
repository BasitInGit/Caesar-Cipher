public abstract class Substitution implements Cipher {
    public abstract char encrypt(char ch);
    public abstract char decrypt(char ch);

    public String encrypt(String s){            //concrete method inherited by subclasses
        String ret = "";
        for (int i =0; i < s.length(); i++) {
            ret += encrypt(s.charAt(i));               //encrypted characters stored in string ret
        }
        return ret;      
    }
    public String decrypt(String s){
        String ret = "";
        for (int i =0; i < s.length(); i++) {
            ret += decrypt(s.charAt(i));
        }
        return ret;
    }

}