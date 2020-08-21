package ru.job4j.tracker;
public class StartUI {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
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

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr(" Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr(" Enter name: ");
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
                int id = Integer.parseInt(input.askStr(" Enter id item: "));
                Item item = new Item();
                item.setName(input.askStr(" Enter name item: "));
                if (tracker.replace(id, item)) {
                    System.out.println(" Complete ");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                int id = Integer.parseInt(input.askStr(" Enter id item: "));
                if (tracker.delete(id)) {
                    System.out.println(" Complete ");
                } else {
                    System.out.println(" Failed ");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                Item item = tracker.findById(Integer.parseInt(input.askStr(" Enter id: ")));
                if (item != null) {
                    System.out.println(" Id: " + item.getId() + " Name: " + item.getName());
                } else {
                    System.out.println(" Not found ");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                Item[] items = tracker.findByName(input.askStr(" Enter name: "));
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
