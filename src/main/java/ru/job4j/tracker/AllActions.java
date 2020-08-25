package ru.job4j.tracker;

public class AllActions implements UserAction {
    @Override
    public String name() {
        return "=== All Items ===";
    }
    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(" Id: " + item.getId() + " Name: " + item.getName());
        }
        return true;
    }
}
