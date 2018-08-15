package com.algorithms.lintcode.amazon.easy;

/**
 * Created on 14/08/2018
 *
 * @author Ming Li
 */
public class CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    
    public boolean isPrime(int x) {
        if (x == 1) {
            return true;
        } else {
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
        
    }
}
