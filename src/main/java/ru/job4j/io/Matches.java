package ru.job4j.io;
import java.util.Scanner;
public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        Scanner input = new Scanner(System.in);
        while (matches > 0) {
            System.out.println("Первый игрок берет спички : ");
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
            int select = Integer.valueOf(input.nextLine());
    if (select == 1) {
        matches = matches - 1;
        System.out.println(" Осталось спичек - " + matches);
    } else if (select == 2) {
        matches = matches - 2;
        System.out.println(" Осталось спичек - " + matches);
    } else if (select == 3) {
        matches = matches - 3;
        System.out.println(" Осталось спичек - " + matches);
    }
            System.out.println("Второй игрок берет спички : ");
            System.out.println("1");
            System.out.println("2");
            System.out.println("3");
            int select1 = Integer.valueOf(input.nextLine());
            if (select1 == 1) {
                matches = matches - 1;
                System.out.println(" Осталось спичек - " + matches);
            } else if (select1 == 2) {
                matches = matches - 2;
                System.out.println(" Осталось спичек - " + matches);
            } else if (select1 == 3) {
                matches = matches - 3;
                System.out.println(" Осталось спичек - " + matches);
            }
            else if (matches == 0) {
                break;
            }
        }
    }
}
