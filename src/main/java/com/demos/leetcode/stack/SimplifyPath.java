package com.demos.leetcode.stack;

import java.util.Stack;

/*
    You are given an absolute path for a Unix-style file system, which always begins with a slash '/'. Your task is to transform this absolute path into its simplified canonical path.

    The rules of a Unix-style file system are as follows:

    A single period '.' represents the current directory.
    A double period '..' represents the previous/parent directory.
    Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
    Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
    The simplified canonical path should follow these rules:

    The path must start with a single slash '/'.
    Directories within the path must be separated by exactly one slash '/'.
    The path must not end with a slash '/', unless it is the root directory.
    The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
    Return the simplified canonical path.



    Example 1:

    Input: path = "/home/"

    Output: "/home"

    Explanation:

    The trailing slash should be removed.

    Example 2:

    Input: path = "/home//foo/"

    Output: "/home/foo"

    Explanation:

    Multiple consecutive slashes are replaced by a single one.

    Example 3:

    Input: path = "/home/user/Documents/../Pictures"

    Output: "/home/user/Pictures"

    Explanation:

    A double period ".." refers to the directory up a level (the parent directory).

    Example 4:

    Input: path = "/../"

    Output: "/"

    Explanation:

    Going one level up from the root directory is not possible.

    Example 5:

    Input: path = "/.../a/../b/c/../d/./"

    Output: "/.../b/d"

    Explanation:

    "..." is a valid name for a directory in this problem.



    Constraints:

    1 <= path.length <= 3000
    path consists of English letters, digits, period '.', slash '/' or '_'.
    path is a valid absolute Unix path.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if(path.length() == 1) return path;
        Stack<String> stack = new Stack<String>();

        //split the path string into an array using / as delimiter
        String[] split = path.split("/");

        //Initialize a string builder
        StringBuilder s = new StringBuilder();

        for (String string : split) {
            //If we encounter .. pop string at the head of the stack if not empty
            if (string.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            }
            //Else we add the current split string onto the stack if it is not empty, or it is not a single dot .
            else if (!string.isEmpty() && !string.equals(".")) {
                stack.push(string);
            }
        }
        //Pop stuff out of the stack as we build the final string to be returned
        while(!stack.isEmpty()) {
            //Initialize a new sb
            StringBuilder b = new StringBuilder();
            //append a / to it
            b.append("/");
            //append whatever is at top of the stack
            b.append(stack.pop());
            //append the main string builder because we are building the path from end to start
            b.append(s);
            //assign b to s for next iteration
            s = b;
        }
        //If the final string is empty, return root i.e "/"
        return s.isEmpty() ? "/" : s.toString();
    }
    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath("/home/user/Documents/../Pictures"));
    }
}
