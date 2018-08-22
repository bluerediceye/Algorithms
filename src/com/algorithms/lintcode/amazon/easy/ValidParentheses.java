package com.algorithms.lintcode.amazon.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created on 14/08/2018
 *
 * @author Ming Li
 */
public class ValidParentheses {
    public boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        for (Character c : s.toCharArray()) {
            
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                case '}':
                case ']':
                    if (!stack.empty() && stack.pop().equals(map.get(c))) {
                        break;
                    } else {
                        return false;
                    }
                default:
                    System.out.println();
            }
        }
        return stack.isEmpty();
    }
}
