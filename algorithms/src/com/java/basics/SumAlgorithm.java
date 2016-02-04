package com.java.basics;

//Find if there are two numbers in already sorted array
//which sum equals to a defined number
public class SumAlgorithm {

    public static void main(String[] args) {
        int[] array = {2, 5, 14, 15, 17, 20};
        System.out.println(sumExists(array, 17));
    }

    public static boolean sumExists(int[] array, int sum) {
        int first = 0;
        int last = array.length - 1;

        while (first < last) {
            int currentSum = array[first] + array[last];

            if (currentSum == sum) {
                System.out.println("First: " + array[first]);
                System.out.println("Last: " + array[last]);
                return true;
            }

            if (currentSum < sum) {
                first++;
            } else {
                last--;
            }
        }

        return false;
    }
}
