package ru.job4j.pojo;

import java.sql.SQLOutput;

public class Library {
    public static void main(String[] args) {
        Book first = new Book("Clean Code", 155);
        Book second = new Book("The Witcher", 400);
        Book third = new Book("Angels and Demons", 350);
        Book four = new Book("Da Vinci code", 360);
        Book[] prods = new Book[4];
        prods[0] = first;
        prods[1] = second;
        prods[2] = third;
        prods[3] = four;

        for (int index = 0; index < prods.length; index++) {
            Book pr = prods[index];
            System.out.println(pr.getName() + " - " + pr.getPages());
        }
        System.out.println(" Swap 0 - 3");
        Book change = prods[0];
        prods[0] = prods[prods.length - 1];
        prods[prods.length - 1] = change;
        for (int index = 0; index < prods.length; index++) {
            Book pr = prods[index];
            System.out.println(pr.getName() + " - " + pr.getPages());
        }
        System.out.println(" Find Book - Clean Code");
        for (int i = 0; i < prods.length; i++) {
                Book call = prods[i];
                if (call.getName().equals("Clean Code")) {
                    System.out.println(call.getName() + " - " + call.getPages());
                }
            }

    }
}