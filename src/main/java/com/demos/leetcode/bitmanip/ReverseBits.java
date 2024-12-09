package com.demos.leetcode.bitmanip;

public class ReverseBits {
    public int reverseBits(int n) {
//        if (n < 0) n *= -1;
//        String binary32Bit = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
//        System.out.println(binary32Bit);
//        return Integer.parseUnsignedInt(new StringBuilder(binary32Bit).reverse().toString(), 2);

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = n & 1;          // Extract the least significant bit
            result = (result << 1) | bit; // Append the bit to the result
            n = n >>> 1;             // Unsigned right-shift
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits r = new ReverseBits();
        System.out.println(r.reverseBits(1));
    }
}

