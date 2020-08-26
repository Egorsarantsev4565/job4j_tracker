package ru.job4j.ex;
public class Fact {
    public static void main(String[] args) {
        System.out.println(new Fact().calc(4));
    }

    public int calc(int n) {
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            if (n < 0) {
                throw new IllegalArgumentException("Проверь параметры");
            }
            rsl *= index;
        }
            return rsl;
        }
}