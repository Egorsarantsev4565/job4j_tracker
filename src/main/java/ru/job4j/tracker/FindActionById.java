package ru.job4j.tracker;

public class FindActionById implements UserAction {
    @Override
    public String name() {
        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item item = tracker.findById(Integer.parseInt(input.askStr(" Enter id: ")));
        if (item != null) {
            System.out.println(" Id: " + item.getId() + " Name: " + item.getName());
        } else {
            System.out.println(" Not found ");
        }
        return true;
    }
}