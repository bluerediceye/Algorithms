package com.algorithms.lintcode.amazon.easy;

/**
 * Created on 14/08/2018
 *
 * @author Ming Li
 */
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public int countPrimeSetBits(int L, int R) {
        // Write your code here
        
        
        int res = 0;
        for(int i=L;i<=R;i++){
            int size = Integer.bitCount(i);
            if(isPrime(size)) res++;
            
        }
        return res;
    }
    
    public static boolean isPrime(int i){
        if(i==0 || i ==1){
            return false;
        }
        if(i == 2 || i ==3){
            return true;
        }
        int tmp = (int)Math.sqrt(i);
        
        for(int j=2;j<=tmp;j++){
            if(i%j==0) return false;
        }
        
        return true;
    }
}
