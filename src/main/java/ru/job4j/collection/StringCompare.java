package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result  = 0;
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            char first = left.charAt(i);
            char second = right.charAt(i);
            if (first - second != 0) {
                result = Character.compare(first, second);
                break;
            }

            if (result == 0) {
                  result = Integer.compare(left.length(), right.length());
              }
        }
        return result;
    }
}