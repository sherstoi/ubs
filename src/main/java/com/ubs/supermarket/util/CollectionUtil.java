package com.ubs.supermarket.util;

import java.util.Collection;
import java.util.Map;

/**
 * Created by iurii on 4/28/17.
 */
public class CollectionUtil {

    public static boolean isNullOrEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static <T> boolean isArrLengthIsEqual(T[] arr, int length) {
        return !isArrEmpty(arr) && arr.length == length;
    }

    private static <T> boolean isArrEmpty(T[] arr) {
        return arr == null || arr.length == 0;
    }
}
