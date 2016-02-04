package com.java.basics;

public class StringsTest {
    public static void main(String[] args) {
        /*String word = "Mot,her,.";
        String symbols = ",.";
        for (char symbol : symbols.toCharArray()) {
            word = word.replace(Character.toString(symbol), "");
        }
        System.out.println(word);*/

        concatString3();
    }

    public static void concatString() {
        StringBuilder builder = new StringBuilder();
        builder.append("str1");
        builder.append("str2");
        builder.append("str3");

        String str = "";
        str += "str1";
        str += "str2";
        str += "str3";

        System.out.println(builder.toString());
    }

    public static void concatString2() {
        String str = "";
        for (int i = 0; i < 9; i++) {
            str += Integer.toString(i);
        }

        System.out.println(str);
    }

    public static void concatString3() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            builder.append(i);
        }

        System.out.println(builder.toString());
    }
}
