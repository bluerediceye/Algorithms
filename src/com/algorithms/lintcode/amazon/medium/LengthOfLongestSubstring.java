package com.algorithms.lintcode.amazon.medium;

/**
 * Created on 15/08/2018
 *
 * @author Ming Li
 */
public class LengthOfLongestSubstring {
    
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null ){
            return -1;
        }
        
        int[] map = new int[256];
        
        int j =0;
        int result = 0;
        for(int i=0;i<s.length();i++){
            while(j<s.length() && map[s.charAt(j)] == 0){
                result = Math.max(result, j-i+1);
                map[s.charAt(j)]=1;
                j++;
            }
            map[s.charAt(i)] = 0;
        }
        
        return result;
    }
}
