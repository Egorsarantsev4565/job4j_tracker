package ru.job4j.tracker;

public class FindActionByName implements UserAction {
    private final Output out;

    public FindActionByName(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findByName(input.askStr(" Enter name: "));
        if (items.length > 0) {
            for (Item item : items) {
                out.println(" Id: " + item.getId() + " Name: " + item.getName());
            }
        } else {
            out.println(" Not found ");
        }
        return true;
    }
}