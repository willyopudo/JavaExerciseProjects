package com.demos.generic;

import java.util.Stack;

public class StoneWall {
    public int minBlocks(int[] H){
        int blockCount = 0;
        Stack<Integer> stack = new java.util.Stack<>();

        for (int height : H) {
            // Remove all blocks that are taller than the current height
            while (!stack.isEmpty() && stack.peek() > height) {
                stack.pop();
            }
            // If the stack is empty or the current height is different, add a new block
            if (stack.isEmpty() || stack.peek() < height) {
                stack.push(height);
                blockCount++;
            }
        }

        return blockCount;
    }

    public static void main(String[] args) {
        StoneWall st = new StoneWall();
        System.out.println(st.minBlocks(new int[]{1,4,2,5,6}));
    }
}
