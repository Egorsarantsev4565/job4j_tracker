package ru.job4j.tracker;

public class FindActionById implements UserAction {
     private final Output out;

    public  FindActionById(Output out) {
        this.out = out;
    }

    @Override
    public String name() {

        return "=== Find item by id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item item = tracker.findById(Integer.parseInt(input.askStr(" Enter id: ")));
        if (item != null) {
            out.println(" Id: " + item.getId() + " Name: " + item.getName());
        } else {
           out.println(" Not found ");
        }
        return true;
    }
}