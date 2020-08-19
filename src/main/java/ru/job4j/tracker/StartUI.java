package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item(5, "Egor");
        System.out.println(item);

        Tracker tracker = new Tracker();
    tracker.add(item);
        tracker.findById(item.getId());
    System.out.println(item);

    }
}
