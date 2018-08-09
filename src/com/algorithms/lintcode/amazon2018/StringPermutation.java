package com.algorithms.lintcode.amazon2018;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 04/08/2018
 *
 * @author Ming Li
 */
public class StringPermutation {
    
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        permutate("", "abcd", res);
        System.out.println(res);
    
        List<String> res2 = new ArrayList<>();
        permutate2("", "abcd", res2);
        System.out.println(res2);
        
    }
    
    public static void permutate(String prefix, String input, List<String> res){
        if(input.length() == 0){
            res.add(prefix);
        } else{
            for(int i=0;i<input.length();i++){
                permutate(prefix + input.charAt(i),
                        input.substring(0, i) + input.substring(i+1), res);
            }
        }
    }
    
    public static void permutate2(String prefix, String rest, List<String> result) {
        if(rest.length() == 0){
            result.add(prefix);
            return;
        }
        
        for(int i=0;i<rest.length();i++){
            permutate(prefix + rest.charAt(i), rest.substring(0, i) + rest.substring(i+1), result);
        }
    }
    
}
