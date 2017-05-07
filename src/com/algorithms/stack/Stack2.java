package com.algorithms.stack;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created on 21/03/2017
 *
 * @author Ming Li
 */
public class Stack2<T> {

    private Integer [] buckets;
    private int count;


    public Stack2(Integer size){
        buckets = new Integer[size];
    }
    ;
    public void push(int v){
        if(!(count < buckets.length)){
            buckets = Arrays.copyOf(buckets, buckets.length << 1);
        }

        buckets[count++] = v;
    }

    public Integer pop(){
        if(count > 0) {
            Integer temp = buckets[count - 1];
            buckets[--count] = null;
            return temp;
        }
        return null;
    }

    public static void main(String[] args) {
        int [] values = {1,2,3,4,5,6,7,8,9,10,11,12};

        Stack2 stack = new Stack2(3);
        for(int value : values){
            stack.push(value);
        }


        Integer value = stack.pop();
        while (value!=null){
            System.out.println(value + " ");
            value = stack.pop();
        }
    }
}
