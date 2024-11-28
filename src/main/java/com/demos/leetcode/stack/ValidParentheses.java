package com.demos.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.


    Example 1:

    Input: s = "()"

    Output: true

    Example 2:

    Input: s = "()[]{}"

    Output: true

    Example 3:

    Input: s = "(]"

    Output: false

    Example 4:

    Input: s = "([])"

    Output: true



    Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null || s.isEmpty() || s.length() % 2 == 1) return false;
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(stack.isEmpty()) return false;
                if(map.get(c) == stack.peek()) stack.pop();
                else break;
            }
            else stack.push(c);
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        ValidParentheses v = new ValidParentheses();
        System.out.println(v.isValid("{{()}}"));
    }
}
