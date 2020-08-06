package ru.job4j.max;

public class Reduce {
    private int[] mas;

    public void to(int[] array) {
        this.mas = array;
    }

    public void print() {
        for (int index = 0; index < mas.length; index++) {
            System.out.println(mas[index]);
        }
    }

    public static void main(String[] args) {
        int[] mas = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(mas);
        reduce.print();
    }
}
