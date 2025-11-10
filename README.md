# Cipher Java Projects
A set of Java projects implementing various classical ciphers, including encryption, decryption, and statistical analysis for cracking.
## Caesar Cipher
-Description:
This project implements the Caesar cipher, a simple substitution cipher that shifts letters by a fixed distance. It also includes a statistical method to crack the cipher using English letter frequencies and chi-squared analysis.
## Features
- Encrypt and decrypt text using a Caesar shift
-Automatically crack Caesar cipher using letter frequency analysis

## How to Use
1.Compile the program:

   javac Caesar.java Brutus.java

2. Run Caesar cipher with a shift:

  java Caesar <shift> "text to encrypt or decrypt"

3. Crack Caesar cipher without the key:
 
   java Brutus "encrypted text"

   
Example:


 $ java Caesar 3 "The ships hung in the sky."
Wkh vklsv kxqj lq wkh vnb.

$ java Brutus "Wkh vklsv kxqj lq wkh vnb."
The ships hung in the sky.

