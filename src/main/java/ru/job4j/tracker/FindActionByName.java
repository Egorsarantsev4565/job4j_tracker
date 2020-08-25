package ru.job4j.tracker;

public class FindActionByName implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findByName(input.askStr(" Enter name: "));
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(" Id: " + item.getId() + " Name: " + item.getName());
            }
        } else {
            System.out.println(" Not found ");
        }
        return true;
    }
}