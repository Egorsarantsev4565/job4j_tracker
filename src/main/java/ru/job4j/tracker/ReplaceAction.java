package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;
    public ReplaceAction(Output out) {
        this.out = out;
    }
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
            out.println(" Complete ");
        }
        return true;
    }
    }
