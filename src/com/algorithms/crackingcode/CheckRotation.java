package com.algorithms.crackingcode;

/**
 * Created on 22/03/2017
 *
 * @author Ming Li
 */
public class CheckRotation {

    private int v1;
    private int v2;
    private String a;
    private String b;

    public boolean isRotation(String s1, String s2){
        if(s1.length() >0 && s1.length() == s2.length()){
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CheckRotation that = (CheckRotation) o;

        if (v1 != that.v1) return false;
        if (v2 != that.v2) return false;
        if (!a.equals(that.a)) return false;
        return b.equals(that.b);
    }

    @Override
    public int hashCode() {
        int result = v1;
        result = 31 * result + v2;
        result = 31 * result + a.hashCode();
        result = 31 * result + b.hashCode();
        return result;
    }
}
