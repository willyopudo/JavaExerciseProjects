package com.demos.interviews.sserve;

public enum EncodingTypes {
    MORSE,
    CAESARS_CIPHER;

    public static EncodingTypes fromString(String type) {
        try {
            return EncodingTypes.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid encoding type: " + type, e);
        }
    }
}
