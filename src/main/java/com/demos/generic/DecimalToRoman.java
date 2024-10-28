package com.demos.generic;

public class DecimalToRoman {
    public static void main(String[] args) {

        int inputDecimal= 547;
        System.out.println("The Integer value of given Roman number is: " + convertDecimalToRoman(inputDecimal));
    }

    private static String convertDecimalToRoman(int num) {
        // Define Roman numeral symbols and their corresponding values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder roman = new StringBuilder();

        // Loop through each value and symbol pair
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
}
