package com.algorithms.amazon9.sde2;

/**
 * Created on 03/03/2017
 *
 * @author Ming Li
 */
public class LongestPalindromic {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromic().longestPalindrome("aaaabcdefgfedcbabcdefghjklmnmlkjhgfedcb"));
    }
    
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        while (len >= 0) {
            for (int i = 0; i + len - 1 < chars.length; i++) {
                int left = i;
                int right = i + len - 1;
                boolean good = true;
                while (left < right) {
                    if (chars[left] != chars[right]) {
                        good = false;
                        break;
                    }
                    left++;
                    right--;
                }
                if (good) {
                    return s.substring(i, i + len);
                }
            }
            --len;
        }
        return "";
    }
    
    public String findLongestPalindrome(String input) {
        char[] chars = input.toCharArray();
        int length = input.length();
        
        while (length >= 0) {
            for (int i = 0; i + length - 1 < chars.length; i++) {
                int left = i;
                int right = i + length - 1;
                boolean good = true;
                while (left < right) {
                    if (chars[left] != chars[right]) {
                        good = false;
                        break;
                    }
                    
                    left++;
                    right++;
                }
                
                if (good) {
                    return input.substring(left, right + 1);
                }
            }
            length--;
        }
        
        return "";
    }
    
    public String longestPalindrome2(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] p = new int[n];
        int center = 0, right = 0;
        for (int i = 1; i < n - 1; i++) {
            int j = 2 * center - i;  //j and i are symmetric around center
            p[i] = (right > i) ? Math.min(right - i, p[j]) : 0;
            
            // Expand palindrome centered at i
            while (T.charAt(i + 1 + p[i]) == T.charAt(i - 1 - p[i]))
                p[i]++;
            
            // If palindrome centered at i expand past right,
            // then adjust center based on expand palindrome
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        
        //  Find the longest palindrome
        int maxLength = 0, centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLength) {
                maxLength = p[i];
                centerIndex = i;
            }
        }
        
        centerIndex = (centerIndex - 1 - maxLength) / 2;
        return s.substring(centerIndex, centerIndex + maxLength);
    }
    
    // preProcess the original string s.
    // For example, s = "abcdefg", then the rvalue = "^#a#b#c#d#e#f#g#$"
    private String preProcess(String s) {
        if (s == null || s.length() == 0) {
            return "^$";
        }
        StringBuilder rvalue = new StringBuilder("^");
        for (int i = 0; i < s.length(); i++)
            rvalue.append("#").append(s.substring(i, i + 1));
        rvalue.append("#$");
        return rvalue.toString();
    }
}
