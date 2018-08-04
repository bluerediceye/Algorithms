package com.algorithms.lintcode;

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
}
