package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr(" Enter id item: "));
        Item item = new Item();
        item.setName(input.askStr(" Enter name item: "));
        if (tracker.replace(id, item)) {
            System.out.println(" Complete ");
        }
        return true;
    }
    }
