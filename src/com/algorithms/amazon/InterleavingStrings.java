package com.algorithms.amazon;


/**
 * Created on 19/04/2017
 *
 * @author Ming Li
 */
public class InterleavingStrings {
    
    
    public static void main(String[] args) {
//        new InterleavingStrings().printIls("AB", "CD", 2,2);
        new InterleavingStrings().printAll("AB", "CD");
    }
    
    // The main function that recursively prints all interleavings.
// The variable iStr is used to store all interleavings (or
// output strings) one by one.
// i is used to pass next available place in iStr
    void printIlsRecur(String str1, String str2, char[] iStr, int m,
                       int n, int i) {
        // Base case: If all characters of str1 and str2 have been
        // included in output string, then print the output string
        if (m == 0 && n == 0) {
            System.out.printf("%s\n", new String(iStr));
        }
        
        // If some characters of str1 are left to be included, then
        // include the  first character from the remaining characters
        // and recur for rest
        if (m != 0) {
            iStr[i] = str1.toCharArray()[0];
            printIlsRecur(str1.substring(1, str1.length()), str2, iStr, m - 1, n, i + 1);
        }
        
        // If some characters of str2 are left to be included, then
        // include the  first character from the remaining characters
        // and recur for rest
        if (n != 0) {
            iStr[i] = str2.toCharArray()[0];
            printIlsRecur(str1, str2.substring(1, str2.length()), iStr, m, n - 1, i + 1);
        }
    }
    
    // Allocates memory for output string and uses printIlsRecur()
// for printing all interleavings
    void printIls(String str1, String str2, int m, int n) {
        
        // Set the terminator for the output string
        char[] iStr = new char[m + n];
        
        // print all interleavings using printIlsRecur()
        printIlsRecur(str1, str2, iStr, m, n, 0);
        
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = (s1 == null) ? 0 : s1.length();
        int len2 = (s2 == null) ? 0 : s2.length();
        int len3 = (s3 == null) ? 0 : s3.length();
    
        if (len3 != len1 + len2) {
            return false;
        }
        
        int i1 = 0, i2 = 0;
        for (int i3 = 0; i3 < len3; i3++) {
            boolean result = false;
            if (i1 < len1 && s1.charAt(i1) == s3.charAt(i3)) {
                i1++;
                result = true;
                continue;
            }
            if (i2 < len2 && s2.charAt(i2) == s3.charAt(i3)) {
                i2++;
                result = true;
                continue;
            }
            
            // return instantly if both s1 and s2 can not pair with s3
            return false;
        }
        
        return true;
    }
    
    public void printAll(String str1, String str2) {
        
        
        int m = str1.length();
        int n = str2.length();
        char[] output = new char[m + n];
        printAll(str1, str2, m, n, output, 0);
        
        
    }
    
    public void printAll(String s1, String s2, int m, int n, char[] output, int position) {
        
        if (m == 0 && n == 0) {
            System.out.println(new String(output));
        }
        
        if (m != 0) {
            output[position] = s1.charAt(0);
            printAll(s1.substring(1, s1.length()), s2, m - 1, n, output, position + 1);
        }
        
        if (n != 0) {
            output[position] = s2.charAt(0);
            printAll(s1, s2.substring(1, s2.length()), m, n - 1, output, position + 1);
        }
    }
}
