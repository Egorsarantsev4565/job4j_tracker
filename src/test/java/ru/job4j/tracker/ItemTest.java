package ru.job4j.tracker;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
public class ItemTest {
    @Test
    public void SortItem() {
        List<Item>list = Arrays.asList(new Item(5), new Item(3), new Item(4), new Item(1), new Item(2));
        List<Item>expected = Arrays.asList(new Item(1), new Item(2), new Item(3), new Item(4), new Item(5));
        Collections.sort(list, new SortItem());
        assertThat(list, is(expected));
    }
    @Test
    public void ReverseSortItem() {
        List<Item>list = Arrays.asList(new Item(5), new Item(3), new Item(4), new Item(1), new Item(2));
        List<Item>expected = Arrays.asList(new Item(5), new Item(4), new Item(3), new Item(2), new Item(1));
        Collections.sort(list, new ReverseSort());
        assertThat(list, is(expected));
    }

}