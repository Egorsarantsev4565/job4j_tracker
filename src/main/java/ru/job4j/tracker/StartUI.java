package ru.job4j.tracker;
import java.util.Scanner;
public class StartUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println(" Select :");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item();
                item.setName(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== All items ====");
                for (Item item : tracker.findAll()) {
                    System.out.println(" Id: " + item.getId() + " Name: " + item.getName());
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.println(" Enter id item : ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println(" Enter name item : ");
                Item item = new Item();
                item.setName(scanner.nextLine());
                if (tracker.replace(id, item)) {
                    System.out.println(" Complete ");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                System.out.println(" Enter Id item : ");
                int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println(" Complete ");
                } else {
                    System.out.println(" Failed ");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                System.out.println(" Enter id : ");
                Item item = tracker.findById(Integer.parseInt(scanner.nextLine()));
                if (item != null) {
                    System.out.println(" Id: " + item.getId() + " Name: " + item.getName());
                } else {
                    System.out.println(" Not found ");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                System.out.println(" Enter name : ");
                Item[] items = tracker.findByName(scanner.nextLine());
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(" Id: " + item.getId() + " Name: " + item.getName());
                    }} else {
                    System.out.println(" Not found ");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }
}
