package com.algorithms.lintcode.amazon201807;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 13/08/2018
 *
 * @author Ming Li
 */
public class FindSumString {
    public int findSubstring(String str, int k) {
        int[] map = new int[256];
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (map[c] == 0) {
                sb.append(c);
                map[c]++;
            } else {
                while (map[c] == 1) {
                    map[sb.charAt(0)]--;
                    sb.deleteCharAt(0);
                }
                sb.append(c);
                map[c]++;
            }
            if (sb.length() == k) {
                set.add(sb.toString());
                map[sb.charAt(0)]--;
                sb.deleteCharAt(0);
            }
        }
        return set.size();
    }
}
