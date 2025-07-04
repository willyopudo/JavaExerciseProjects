package com.demos.interviews.sserve;
import java.util.Map;
import java.util.HashMap;

public class Translations {
    public static final Map<Character, String> ALPHABET_TO_MORSE;
    public static final Map<Character, Character> CAESARS_CIPHER;

    static {
        ALPHABET_TO_MORSE = new HashMap<>();
        ALPHABET_TO_MORSE.put('a', ".-");
        ALPHABET_TO_MORSE.put('b', "-...");
        ALPHABET_TO_MORSE.put('c',  "-.-.");
        ALPHABET_TO_MORSE.put('d',  "-..");
        ALPHABET_TO_MORSE.put('e',    ".");
        ALPHABET_TO_MORSE.put('f', "..-.");
        ALPHABET_TO_MORSE.put('g',  "--.");
        ALPHABET_TO_MORSE.put('h', "....");
        ALPHABET_TO_MORSE.put('i',   "..");
        ALPHABET_TO_MORSE.put('j', ".---");
        ALPHABET_TO_MORSE.put('k',   "-.-");
        ALPHABET_TO_MORSE.put('l', ".-..");
        ALPHABET_TO_MORSE.put('m',   "--");
        ALPHABET_TO_MORSE.put('n',   "-.");
        ALPHABET_TO_MORSE.put('o',  "---");
        ALPHABET_TO_MORSE.put('p', ".--.");
        ALPHABET_TO_MORSE.put('q', "--.-");
        ALPHABET_TO_MORSE.put('r', ".-.");
        ALPHABET_TO_MORSE.put('s',  "...");
        ALPHABET_TO_MORSE.put('t',   "-");
        ALPHABET_TO_MORSE.put('u',  "..-");
        ALPHABET_TO_MORSE.put('v', "...-");
        ALPHABET_TO_MORSE.put('w',  ".--");
        ALPHABET_TO_MORSE.put('x', "-..-");
        ALPHABET_TO_MORSE.put('y', "-.--");
        ALPHABET_TO_MORSE.put('z', "--..");
        ALPHABET_TO_MORSE.put('1', ".----");
        ALPHABET_TO_MORSE.put('2',"..---");
        ALPHABET_TO_MORSE.put('3', "...--");
        ALPHABET_TO_MORSE.put('4', "....-");
        ALPHABET_TO_MORSE.put('5', ".....");
        ALPHABET_TO_MORSE.put('6', "-....");
        ALPHABET_TO_MORSE.put('7', "--...");
        ALPHABET_TO_MORSE.put('8', "---..");
        ALPHABET_TO_MORSE.put('9', "----.");
        ALPHABET_TO_MORSE.put('0', "-----");
        ALPHABET_TO_MORSE.put(' ', "S");


        CAESARS_CIPHER = new HashMap<>();
        CAESARS_CIPHER.put('a','e');
        CAESARS_CIPHER.put('b','f');
        CAESARS_CIPHER.put('c','g');
        CAESARS_CIPHER.put('d','h');
        CAESARS_CIPHER.put('e','i');
        CAESARS_CIPHER.put('f','j');
        CAESARS_CIPHER.put('g','k');
        CAESARS_CIPHER.put('h','l');
        CAESARS_CIPHER.put('i','m');
        CAESARS_CIPHER.put('j','n');
        CAESARS_CIPHER.put('k','o');
        CAESARS_CIPHER.put('l','p');
        CAESARS_CIPHER.put('m','q');
        CAESARS_CIPHER.put('n','r');
        CAESARS_CIPHER.put('o','s');
        CAESARS_CIPHER.put('p','t');
        CAESARS_CIPHER.put('q','u');
        CAESARS_CIPHER.put('r','v');
        CAESARS_CIPHER.put('s','w');
        CAESARS_CIPHER.put('t','x');
        CAESARS_CIPHER.put('u','y');
        CAESARS_CIPHER.put('v','z');
        CAESARS_CIPHER.put('w','1');
        CAESARS_CIPHER.put('x','2');
        CAESARS_CIPHER.put('y','3');
        CAESARS_CIPHER.put('z','4');
        CAESARS_CIPHER.put('1','5');
        CAESARS_CIPHER.put('2','6');
        CAESARS_CIPHER.put('3','7');
        CAESARS_CIPHER.put('4','8');
        CAESARS_CIPHER.put('5','9');
        CAESARS_CIPHER.put('6','0');
        CAESARS_CIPHER.put('7','a');
        CAESARS_CIPHER.put('8','b');
        CAESARS_CIPHER.put('9','c');
        CAESARS_CIPHER.put('0','d');
        CAESARS_CIPHER.put(' ','S');
    }
}
