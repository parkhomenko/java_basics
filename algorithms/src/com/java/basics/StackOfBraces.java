package com.java.basics;

import java.util.Stack;

// Defines if the string of braces is properly nested
// {[()()]} - nested, i.e. returns 1
// ([)()] - not nested, i.e. returns 0
public class StackOfBraces {

    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));
    }

    public static int solution(String s) {
        char[] chs = {'(', '{', '[', ')', '}', ']'};
        char[] chars = s.toCharArray();
        Stack stack = new Stack();
        for (char aChar : chars) {
            if (aChar == chs[3] || aChar == chs[4] || aChar == chs[5]) {
                if (stack.isEmpty()) {
                    return 0;
                }

                char prev = (char) stack.pop();
                char current = '0';

                for (int i = 0; i < chs.length; i++) {
                    if (chs[i] == prev) {
                        current = chs[i + 3];
                        break;
                    }
                }

                if (current != aChar) {
                    return 0;
                }
            } else {
                stack.push(aChar);
            }
        }

        if (stack.isEmpty()) {
            return 1;
        }

        return 0;
    }
}
