package com.algorithms.amazon9.sde1;

import java.util.Stack;

/**
 * Created on 01/03/2017
 *
 * @author Ming Li
 */
public class CountValidParenthesis {

    public static void main(String[] args) {
        String input = "{sjflsdfjlsd{{{}}}}(sdfsd)[][()sdfsdfs]";

        System.out.println(countParenthesis(input));
    }


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray())
        {
            if(c == ')')
            {
                if(!stack.empty() && stack.peek() == '(') stack.pop();
                else return false;
            }
            else if(c == ']')
            {
                if(!stack.empty() && stack.peek() == '[') stack.pop();
                else return false;
            }
            else if(c == '}')
            {
                if(!stack.empty() && stack.peek() == '{') stack.pop();
                else return false;
            }
            else stack.push(c);
        }
        return stack.empty();
    }

    public static int countParenthesis(String input){
        Stack<Character> store = new Stack<Character>();
        int count = 0;
        for(char c : input.toCharArray()){
            if('{' == c){
                store.push(c); continue;
            }

            if('(' == c){
                store.push(c);  continue;
            }

            if('[' == c) {
                store.push(c);continue;
            }

            if('}' == c ){
                if( !store.isEmpty()&& '{' ==store.peek() ){
                    store.pop();
                    count++;
                }else{
                    return -1;
                }
            }

            if(')' == c){
                if(!store.isEmpty() && '(' == store.peek()){
                    store.pop();
                    count++;
                }else{
                    return -1;
                }
            }

            if(']' == c ) {
                if(!store.isEmpty() && '[' == store.peek()){
                    store.pop();
                    count++;
                }else{
                    return -1;
                }
            }
        }

        return count;
    }
}
