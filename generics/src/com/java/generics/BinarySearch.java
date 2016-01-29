package com.java.generics;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = obj1;

        if (obj1.equals(obj2)) System.out.println(true);
        else System.out.println(false);

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(findNumber(array, 10));
    }

    public static boolean findNumber(int[] array, int number) {
        int index = array.length / 2;

        if (array[index] == number) {
            return true;
        }

        if (array.length <= 1) {
            return false;
        } else {
            if (array[index] < number) {
                return findNumber(Arrays.copyOfRange(array, index + 1, array.length), number);
            } else {
                return findNumber(Arrays.copyOfRange(array, 0, index), number);
            }
        }
    }
}
