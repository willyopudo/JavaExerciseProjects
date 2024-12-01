package com.demos.generic;

import java.util.HashMap;
import java.util.Map;

public class RomanToDecimal {
    public static void main(String[] args) {

        String inputRoman= "IX";
        System.out.println("The Integer value of given Roman number is: " + convertRomanToDecimal(inputRoman));
    }

    private static int convertRomanToDecimal(String s){
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int sum = 0;
        for(int i=0;i<s.length();i++){
            int val1 = romanMap.get(s.charAt(i));
            if(i+1 < s.length()){
                int val2 = romanMap.get(s.charAt(i + 1));
                sum = val1 >= val2 ? sum + val1 : sum - val1;
            }
            else
                sum += val1;
        }
        return sum;

        //Alternate genius solution :)
//        int ans = 0, num = 0;
//        for (int i = s.length()-1; i >= 0; i--) {
//            switch(s.charAt(i)) {
//                case 'I': num = 1; break;
//                case 'V': num = 5; break;
//                case 'X': num = 10; break;
//                case 'L': num = 50; break;
//                case 'C': num = 100; break;
//                case 'D': num = 500; break;
//                case 'M': num = 1000; break;
//            }
//            if (4 * num < ans) ans -= num;
//            else ans += num;
//        }
//        return ans;
    }
}
