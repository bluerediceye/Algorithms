package com.algorithms.lintcode.amazon2018;

/**
 * Created on 07/08/2018
 *
 * @author Ming Li
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        // write your code here
        char[] input = s.toCharArray();
        
        reverse(input, 0, s.length() -1);
    
        int start = 0;
        for(int i=0;i<=input.length;i++){
            if(i==input.length || input[i] == ' '){ 
                reverse(input, start, i-1);
                start = i + 1;
            }
        }
        
        return new String(input);
    }
    
    public void reverse(char[] input, int i, int j){
        while(i<j){
            char tmp = input[j];
            input[j] = input[i];
            input[i] = tmp;
            i++;
            j--;
        }
    }
    
    public String reverseWords2(String s) {
        // write your code here
        if(s.length() == 0 || s == null){
            return " ";
        }
        String[] array = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i = array.length - 1; i >= 0; i--){
            if(!array[i].equals("")) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
}
