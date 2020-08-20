package ru.job4j.io;
import java.util.Scanner;
public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        Scanner input = new Scanner(System.in);
        while (matches > 0) {
            System.out.println("Первый игрок берет спички : 1 - 2 - 3");

            int select = Integer.valueOf(input.nextLine());
            if (select == 1 || select == 2 || select == 3) {
                matches = matches - select;
                System.out.println(" Осталось спичек - " + matches);
            } else if (matches <= 0) {
                System.out.println("Спичек больше не осталось");
            }
            System.out.println("Второй игрок берет спички : 1 - 2 - 3 ");
            select = Integer.valueOf(input.nextLine());
            if (select == 1 || select == 2 || select == 3) {
                matches = matches - select;
                System.out.println(" Осталось спичек - " + matches);
            } else if (matches <= 0) {
                System.out.println("Спичек больше не осталось");


            }
        }
    }
}
