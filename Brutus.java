/**
 * A method for decrypting cipher encrypted text using a chisquared frequency formula.
 */
public class Brutus {
    
    
    /**
     * counts how many times each letter is used in a given text.
     * 
     * This is done by first converting given text to lowercase 
     * then runs a loop which ends at the final letter of given text.
     * 
     * The loop stores the index of each character in a 26 alphabet integer array
     * that updates each time the character reappears.
     * 
     * @param text the string to consider.
     * @return an array containing the counts of each letter.
     * 
     */
    public static int [] count(String text){
        String textC = text.toLowerCase();
        
    
        int [] reNum = new int[26];


        for (int i = 0; i<text.length();i++) {
            if ((int)textC.charAt(i) >= 97 && (int)textC.charAt(i) <= 122) { 
                int x = textC.charAt(i) - (int) 'a';
                reNum[x]+=1;
            }
        }
        return reNum;

    }



    /**
     *  Calculates the frequency of each letter in the given text.
     * 
     * This is done by diving the count of each letter by the length of the total text.
     * 
     * @param text the string to consider.
     * @return an array containing the frequency of each letter in the text.
     * 
     */
    public static double [] frequency(String text) {
        String textC = text.toLowerCase();
        
    
        double [] reNum = new double[26];




        for (int i = 0; i<text.length();i++) {
            if ((int)textC.charAt(i) >= 97 && (int)textC.charAt(i) <= 122) { 
                int x = textC.charAt(i) - (int) 'a';
                reNum[x]+=1.0/(double)text.length();
            }
        }

        return reNum;
    }


    /**
     * Calculates the chi-Squared value using two frequency values.
     * 
     * This is done by taking the difference between the calculated frequency 
     * of a given text from the english letters frequency, squaring the result
     * and diving it by the english letter frequency
     * 
     * the result for each letter is stored in a double list.
     * @param freq  the calculated frequency distribution
     * @param eng   the expected english letters frequency distribution
     * @return the chi-Squared value
     * 
     */
    public static double chiSquared(double [] freq, double [] eng) {
        double chiray = 0;

        for (int i = 0; i< 26; i++) {
            chiray  += ((freq[i]-eng[i])*(freq[i]-eng[i]))/eng[i];
        }
        return chiray;
    }


    
    /**
     *  An array of english letters frequency distribution.
     * 
     * 
     */
    public static final double[] english = {
        0.0855, 0.0160, 0.0316, 0.0387, 0.1210, 0.0218, 0.0209, 0.0496, 0.0733,
        0.0022, 0.0081, 0.0421, 0.0253, 0.0717, 0.0747, 0.0207, 0.0010, 0.0633,
        0.0673, 0.0894, 0.0268, 0.0106, 0.0183, 0.0019, 0.0172, 0.0011
    };

    /**
     * The main method with the method to decrypt a Caesar cipher encrypted text.
     * 
     * This works by shifting the charcaters in the text by a constant value each time
     * starting from 0 to 25
     * the chisquared value of the new text  from each iteration is calculated
     * and the lowest chisquared value is recovered and outputed.
     * 
     * The method also ensures it receives the right amount of arguements and complains otherwise.
     *  
     * @param args command line arguements delivering encrypted text
     * 
     * 
     */
    public static void main(String [] args) {
        String words = "cipher text";
        
        if (args.length == 0){
            System.out.println("Too few parameters!");
            System.out.println("Usage: java Brutus " +"\"" + words +"\"");

        } 
        else if (args.length ==1) {
            double smallestChi = 10000;
            String bestString = "";
            String text = args[0];
            for (int i = 0; i<26; i++) {
                String s = Caesar.rotate(i, text);
                double chi = chiSquared(frequency(s), english);
                if (chi < smallestChi) {
                    smallestChi = chi;
                    bestString = s;
                }
                
            }
            System.out.println(bestString);
            
        } 
        else {
            System.out.println("Too many parameters!");
            System.out.println("Usage: java Brutus " +"\"" + words +"\"");
        }
        

    }
}
