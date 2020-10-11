package ru.job4j.tracker;

public class AllActions implements UserAction {
    private final Output out;

    public AllActions(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== All Items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            out.println(" Id: " + item.getId() + " Name: " + item.getName());
        }
        return true;
    }
}
