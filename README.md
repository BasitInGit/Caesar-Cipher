# Cipher Java Projects
A set of Java projects implementing various classical ciphers, including encryption, decryption, and statistical analysis for cracking.
## 1. Caesar Cipher
-Description:
This project implements the Caesar cipher, a simple substitution cipher that shifts letters by a fixed distance. It also includes a statistical method to crack the cipher using English letter frequencies and chi-squared analysis.
## Features
- Encrypt and decrypt text using a Caesar shift
- Automatically crack Caesar cipher using letter frequency analysis

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

## 2. Substitution Ciphers
Description:
This project implements several substitution ciphers in an object-oriented design. It includes:
1. Substitution – abstract class implementing the Cipher interface for character-by-character encryption/decryption.

2. MonoAlphaSubstitution – monoalphabetical substitution cipher with a customizable key.

3. Caesar – special case of monoalphabetical substitution with a fixed shift.

4. Vigenere – polyalphabetic substitution cipher using a keyword for encryption/decryption.

## Features
-Encrypt/decrypt with monoalphabetical substitution

-Encrypt/decrypt with Caesar cipher

-Encrypt/decrypt with Vigenère cipher

-Validates command-line arguments for proper usage

## How to Use
1.Compile the project:

javac Substitution.java MonoAlphaSubstitution.java Caesar.java Vigenere.java

2. Run MonoAlphaSubstitution:

java MonoAlphaSubstitution encrypt <key> "text"

java MonoAlphaSubstitution decrypt <key> "text"

3. Run Caesar:

   java Caesar encrypt <shift> "text"
   
   java Caesar decrypt <shift> "text"

5. Run Vigenère:

   java Vigenere encrypt <keyword> "text"
   
   java Vigenere decrypt <keyword> "text"
