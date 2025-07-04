package com.demos.interviews.sserve;

public class Main {
    public static void main(String[] args) {
        IEncoder encoder = new EncoderService();

        String input = "java interview";
        try {
            String morseEncoded = encoder.encode(input, EncodingTypes.fromString("MORSE"));
            System.out.println("Morse Encoded: " + morseEncoded);
        } catch (IllegalArgumentException e) {
            System.err.println("Error encoding to Morse: " + e.getMessage());
        }
        try{
            String caesarEncoded = encoder.encode(input, EncodingTypes.fromString("CAESARS_CIPHER"));
            System.out.println("Caesar Cipher Encoded: " + caesarEncoded);
        } catch (IllegalArgumentException e) {
            System.err.println("Error encoding to Caesar Cipher: " + e.getMessage());
        }
    }
}
