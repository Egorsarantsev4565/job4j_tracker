package ru.job4j.lambda;
import java.util.Comparator;
import java.util.Arrays;
public class SortBox {
    public static void main(String[] args) {
        String[] line = {"A", "AA", "AAA", "AAAA", "AAAAA"};
        Comparator<String> lineSt = ( left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return right.length() - left.length();
        };
        Arrays.sort(line, lineSt);
        }
    }

