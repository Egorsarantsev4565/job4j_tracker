package ru.job4j.io;
import java.util.Scanner;
public class Matches {
    public static void main(String[] args) {
        int matches = 11;
        boolean player = true;
        boolean player1 = true;
        boolean player2 = false;
        Scanner input = new Scanner(System.in);
        while (matches > 0) {
            String playerName = player ? "player_1" : "player_2";
            System.out.println(playerName + " берет спички : 1 - 2 - 3");
            int select = Integer.valueOf(input.nextLine());
            if (select == 1 || select == 2 || select == 3) {
                matches = matches - select;
                if (matches <= 0) {
                    System.out.println(" Спички закончились. Победитель : " + playerName );


                } System.out.println(" Осталось спичек - " + matches);
                player = !player;
            }

            }

    }
}

