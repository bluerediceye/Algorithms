package com.algorithms.lintcode.amazon.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class LetterCombinationPhoneNumber {
    
    private String[] numbers = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> results = new ArrayList<>();
        
        dfs("", digits, results);
        
        return results;
    }
    
    public void dfs(String prefix, String digits, List<String> results) {
        
        if (prefix.length() == digits.length()) {
            results.add(prefix);
            return;
        }
        
        String x = numbers[digits.charAt(prefix.length()) - '0'];
        for (Character character : x.toCharArray()) {
            dfs(prefix + character, digits, results);
        }
    }
    
    public static void main(String[] args) {
        List<String> out = new LetterCombinationPhoneNumber().letterCombinations("23");
        System.out.println(out);
    }
}
