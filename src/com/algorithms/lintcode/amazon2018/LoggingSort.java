package com.algorithms.lintcode.amazon2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created on 06/08/2018
 *
 * @author Ming Li
 */
public class LoggingSort {
    private Comparator<String> comparator = (o1, o2) -> {
        int index1 = o1.indexOf(' ');
        int index2 = o2.indexOf(' ');
        
        String head1 = o1.substring(0, index1);
        String head2 = o2.substring(0, index2);
        
        String body1 = o1.substring(index1+1);
        String body2 = o2.substring(index2+1);
        
        if(body1.compareTo(body2) == 0){
            return head1.compareTo(head2);
        }else {
            return body1.compareTo(body2);
        }
    };
    
    public String[] logSort(String[] logs) {
        // Write your code here
    
        String[] results = new String[logs.length];
        List<String> letters = new ArrayList<>();
        List<String> numbers = new ArrayList<>();
        
        for(int i=0;i<logs.length;i++){
            String line = logs[i];
            String body = line.substring(line.indexOf(' ') + 1);
            
            if(body.charAt(0)>='0'&&body.charAt(0)<='9'){
                numbers.add(line);
            }else{
                letters.add(line);
            }
        }
        String[] lettersArray = letters.toArray(new String[]{});
        Arrays.sort(lettersArray, comparator);
    
        int start = 0;
        for(String s:lettersArray){
            results[start++] = s;
        }
        for(String s:numbers){
            results[start++] = s;
        }
        
        return results;
    }
}
