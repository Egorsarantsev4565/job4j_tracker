package ru.job4j.tracker;
import java.util.ArrayList;
import java.util.List;

import java.time.format.DateTimeFormatter;
public class StartUI {
    private final Output out;

    public StartUI(Output out) {

        this.out = out;
    }

    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(item.getCreated().format(formatter));

        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(output));
                        actions.add(new ReplaceAction(output));
                        actions.add(new AllActions(output));
                        actions.add(new FindActionById(output));
                        actions.add(new FindActionByName(output));
                        actions.add(new DeleteAction(output));
                        actions.add(new ExitAction(output));

        new StartUI(output).init(input, tracker, actions);
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

}
