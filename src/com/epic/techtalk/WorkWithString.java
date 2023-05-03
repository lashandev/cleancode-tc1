package com.epic.techtalk;

public class WorkWithString {
    public static void main(String[] args) {
        String str1 = "My name is";
        str1 = str1 + " Lashan Chandika";
        System.out.println(str1);

        StringBuilder str2 = new StringBuilder("My name is");
        str2.append(" Lashan Chandika");
        System.out.println(str2);
    }
}
