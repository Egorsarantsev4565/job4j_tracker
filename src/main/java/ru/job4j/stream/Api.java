package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Api {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-1);
        numbers.add(2);
        numbers.add(-2);
        numbers.add(3);
        numbers.add(-3);
       List<Integer> plusNum = numbers.stream().filter(i -> i >= 0).collect(Collectors.toList());
        plusNum.forEach(System.out::println);
    }
}