package com.algorithms.lintcode.amazon.medium;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class ReverseWordII {
    public static void main(java.lang.String[] args) {
        char[] str = new ReverseWordII().reverseWords("abc def".toCharArray());
        System.out.println(new java.lang.String(str));
    }
    
    public char[] reverseWords(char[] str) {
        if (str == null) {
            return null;
        }
        
        reverse(str, 0, str.length - 1);
        
        int wordStart = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = i; j < str.length; j++) {
                if (str[j] == ' ') {
                    reverse(str, i, j - 1);
                    i = j + 1;
                    break;
                }
                
                if (j == str.length - 1) {
                    reverse(str, i, j);
                    break;
                }
            }
        }
        
        return str;
    }
    
    void reverse(char[] str, int left, int right) {
        while (left <= right) {
            swap(str, left, right);
            left++;
            right--;
        }
    }
    
    void swap(char[] str, int a, int b) {
        char tmp = str[a];
        str[a] = str[b];
        str[b] = tmp;
    }
}
