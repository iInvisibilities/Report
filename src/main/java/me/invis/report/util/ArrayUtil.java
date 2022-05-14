package me.invis.report.util;

public class ArrayUtil {

    public static <A> boolean contains(A[] array, A item) {
        for (A a : array) if(item.equals(a)) return true;

        return false;
    }

}
