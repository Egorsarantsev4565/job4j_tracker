package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }
        @Override
        public boolean execute(Input input, Tracker tracker) {
            int id = Integer.parseInt(input.askStr(" Enter id item: "));
            if (tracker.delete(id)) {
                System.out.println(" Complete ");
            } else {
                System.out.println(" Failed ");
            }
       return true;
    }
}
