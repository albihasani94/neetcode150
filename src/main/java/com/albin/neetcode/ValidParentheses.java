package com.albin.neetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Category: Stack
 *
 * <a href="https://neetcode.io/problems/validate-parentheses/question?list=neetcode150">NeetCode: Valid Parentheses</a>
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (var ch : s.toCharArray()) {
            switch (ch) {
                case '(' -> stack.push(')');
                case '{' -> stack.push('}');
                case '[' -> stack.push(']');
                default -> {
                    if (stack.isEmpty() || stack.pop() != ch) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
