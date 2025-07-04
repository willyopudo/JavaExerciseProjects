package com.demos.interviews.sserve;

public interface IEncoder {
    /**
     * Encodes the input string based on the specified encoding type.
     *
     * @param input the string to encode
     * @param encodingType the type of encoding to use
     * @return the encoded string
     */
    String encode(String input, EncodingTypes encodingType);
}
