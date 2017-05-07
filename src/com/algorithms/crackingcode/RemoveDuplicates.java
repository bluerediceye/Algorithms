package com.algorithms.crackingcode;

/**
 * Created on 22/03/2017
 *
 * @author Ming Li
 */
public class RemoveDuplicates {

    public String removeDuplicates(char[]s){

        int tail=1;
        for(int i=1;i<s.length;i++){

            int j=0;
            for(;j<tail;j++){
                if(s[i] == s[j]) break;
            }

            if(j==tail){
                s[tail] = s[i];
                tail++;
            }
        }

//        for(int i = tail + 1;i<s.length;i++){
//            s[i] = 0;
//        }
        s[tail]=0;

        return new String(s);
    }

    public static void main(String[] args) {
        String s = "hello world";
        System.out.printf(new RemoveDuplicates().removeDuplicates(s.toCharArray()));
    }
}
