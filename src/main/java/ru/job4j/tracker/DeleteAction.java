package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

        @Override
        public boolean execute(Input input, Tracker tracker) {
            int id = Integer.parseInt(input.askStr(" Enter id item: "));
            if (tracker.delete(id)) {
                out.println(" Complete ");
            } else {
               out.println(" Failed ");
            }
       return true;
    }
}
