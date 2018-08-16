package com.algorithms.lintcode.amazon.medium;

/**
 * Created on 16/08/2018
 *
 * @author Ming Li
 */
public class BestTimeToSellAndBuy {
    public int maxProfit_slow(int[] prices) {
        
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int max = 0;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-prices[i]>max){
                    max = prices[j]-prices[i];
                }
            }
        }
        return max;
        
    }
    
    public int maxProfit(int[]prices){
        if(prices == null ||prices.length == 0){
            return 0;
        }
        
        int min = prices[0];
        int max = 0;
    
        for (int currentValue : prices) {
            int profit = currentValue - min;
            if (profit > max) {
                max = profit;
            }
            if (currentValue < min) {
                min = currentValue;
            }
        }
        return max;
    }
}
