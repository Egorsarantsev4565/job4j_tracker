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
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr(" Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
    }

    public static void allItems(Input input, Tracker tracker) {
        System.out.println("=== All Items ===");
        for (Item item : tracker.findAll()) {
            System.out.println(" Id: " + item.getId() + " Name: " + item.getName());
    } }

            public static void replaceItem(Input input, Tracker tracker) {
                System.out.println("=== Edit item ===");
                int id = Integer.parseInt(input.askStr(" Enter id item: "));
                Item item = new Item();
                item.setName(input.askStr(" Enter name item: "));
                if (tracker.replace(id, item)) {
                    System.out.println(" Complete ");
                }
        }

        public static void deleteItem(Input input, Tracker tracker) {
            System.out.println("=== Delete item ===");
            int id = Integer.parseInt(input.askStr(" Enter id item: "));
            if (tracker.delete(id)) {
                System.out.println(" Complete ");
            } else {
                System.out.println(" Failed ");
            }
    }


    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by id ===");
        Item item = tracker.findById(Integer.parseInt(input.askStr(" Enter id: ")));
        if (item != null) {
            System.out.println(" Id: " + item.getId() + " Name: " + item.getName());
        } else {
            System.out.println(" Not found ");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        Item[] items = tracker.findByName(input.askStr(" Enter name: "));
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(" Id: " + item.getId() + " Name: " + item.getName());
            }
        } else {
            System.out.println(" Not found ");
        }
    }



    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
               StartUI.allItems(input, tracker);
                }
             else if (select == 2) {
                StartUI.replaceItem(input, tracker);
                }
             else if (select == 3) {
               StartUI.deleteItem(input, tracker);
                }
             else if (select == 4) {
                StartUI.findItemById(input, tracker);
                }
             else if (select == 5) {
               StartUI.findItemByName(input, tracker);
                }
             else if (select == 6) {
                run = false;
            }
        }
    }
}
