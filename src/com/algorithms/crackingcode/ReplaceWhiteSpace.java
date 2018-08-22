package com.algorithms.crackingcode;

/**
 * Created on 22/03/2017
 *
 * @author Ming Li
 */
public class ReplaceWhiteSpace {
    
    
    public static void main(String[] args) {
        System.out.println(new ReplaceWhiteSpace().replace("  ssldfjds urowero"));
        System.out.println(new ReplaceWhiteSpace().replace("hello world"));
    }
    
    public String replace(String s) {
        
        char[] c = s.toCharArray();
        
        int count = 0;
        for (char ch : c) {
            if (ch == ' ') {
                count++;
            }
        }
        
        char[] ss = new char[s.length() + (count << 1)];
        
        int i = 0;
        for (char ch : c) {
            if (ch == ' ') {
                ss[i] = '%';
                ss[i + 1] = '2';
                ss[i + 2] = '0';
                i = i + 3;
            } else {
                ss[i] = ch;
                i++;
            }
        }
        
        return new String(ss);
        
    }
}
