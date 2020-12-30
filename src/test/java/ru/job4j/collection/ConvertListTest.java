package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertListTest {
    @Test
    public void whenTwoList() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1});
        in.add(new int[] {2, 3});
        List<Integer> expect = List.of(1, 2, 3);
        assertThat(ConvertList.convert(in), is(expect));
    }

    @Test
    public void whenTest() {
        List<int[]> in = new ArrayList<>();
        in.add(new int[] {1, 2, 3, 4, 5});
        in.add(new int[] {6, 7, 8, 9});
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(ConvertList.convert(in), is(expect));
    }
}