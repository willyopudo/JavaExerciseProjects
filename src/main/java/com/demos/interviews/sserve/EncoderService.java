package com.demos.interviews.sserve;

import java.util.Map;

public class EncoderService implements IEncoder {

    @Override
    public String encode(String input, EncodingTypes encodingType) {
        if(input == null || input.isEmpty()) {
            return input; // Return empty or null input as is
        }

        if (encodingType == EncodingTypes.MORSE) {
            return encodeToMorse(input);
        } else if (encodingType == EncodingTypes.CAESARS_CIPHER) {
            return encodeToCaesarsCipher(input);
        }
        throw new IllegalArgumentException("Unsupported encoding type: " + encodingType);
    }

    private String encodeToMorse(String input) {
        return doEncode(input, Translations.ALPHABET_TO_MORSE);
    }

    private String encodeToCaesarsCipher(String input) {
        return doEncode(input, Translations.CAESARS_CIPHER);
    }

    private String doEncode(String input, Map<?,?> translationMap) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : input.toLowerCase().toCharArray()) {
            Object translatedChar = translationMap.get(c);
            if (translatedChar != null) {
                encodedText.append(translatedChar);
            } else {
                throw new IllegalArgumentException("Character '" + c + "' cannot be encoded.");
            }
        }
        return encodedText.toString().trim();
    }
}
