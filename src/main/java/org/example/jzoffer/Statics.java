package org.example.jzoffer;

public class Statics {
    public static void main(String[] args) {
        count("3543refwer ew ");
    }

    public static void count(String str) {
        Integer kg = 0;
        Integer num = 0;
        Integer en = 0;
        Integer other = 0;
        if (str == null || str.length() == 0) return;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                kg++;
            } else if (c >= '0' && c <= '9') {
                num++;
            } else if ((c >= 'a' && c <= 'z' || (c >= 'A' && c <= 'Z'))) {
                en++;
            } else {
                other++;
            }
        }
        System.out.println(kg);
        System.out.println(num);
        System.out.println(en);
        System.out.println(other);
    }
}
