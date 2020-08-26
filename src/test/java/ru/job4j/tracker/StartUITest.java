package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()),replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", Integer.toString(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. Exit" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindAllActions() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Item1"));
        Item item2 = tracker.add(new Item("Item2"));
        UserAction[] actions = {
                new AllActions(output),
                new ExitAction(output)
        };
new StartUI(output).init(in, tracker, actions);
assertThat(output.toString(), is(
        "Menu." + System.lineSeparator() +
                "0. === All Items ===" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                " Id: " + item1.getId() + " Name: " + item1.getName() + System.lineSeparator() +
                " Id: " + item2.getId() + " Name: " + item2.getName() + System.lineSeparator() +

                "Menu." + System.lineSeparator() +
                "0. === All Items ===" + System.lineSeparator() +
                "1. Exit" + System.lineSeparator() + "=== Exit programm ====" + System.lineSeparator()
));
    }

    @Test
    public void whenActionFindById() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"} );
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("item"));
        UserAction[] actions = {
                new FindActionById(output),
                new ExitAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is(
                "Menu." + System.lineSeparator() +
                        "0. === Find item by id ===" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() +
                        " Id: " + item.getId() + " Name: " + item.getName() + System.lineSeparator() +

                        "Menu." +  System.lineSeparator() +
                        "0. === Find item by id ===" + System.lineSeparator() +
                        "1. Exit" + System.lineSeparator() + "=== Exit programm ====" + System.lineSeparator()
        ));

    }
@Test
    public void whenFindActionByName() {
    Output output = new StubOutput();
    String nameItem = new String();
    Input in = new StubInput(
            new String[] {"0",nameItem,"1"} );
    Tracker tracker = new Tracker();
    Item item = tracker.add(new Item(nameItem));
    UserAction[] actions = {
            new FindActionByName(output),
            new ExitAction(output)
    };
    new StartUI(output).init(in, tracker, actions);
    assertThat(output.toString(), is(
            "Menu." + System.lineSeparator() +
                    "0. === Find items by name ===" + System.lineSeparator() +
                    "1. Exit" + System.lineSeparator() +
                    " Id: " + item.getId() + " Name: " + item.getName() + System.lineSeparator() +

                    "Menu." +  System.lineSeparator() +
                    "0. === Find items by name ===" + System.lineSeparator() +
                    "1. Exit" + System.lineSeparator() + "=== Exit programm ====" + System.lineSeparator()
    ));
}


}