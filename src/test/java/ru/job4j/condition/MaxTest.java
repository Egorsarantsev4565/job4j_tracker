package ru.job4j.condition;

import  org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirst() {
        assertThat(Max.max(5, 4, 3, 2), is(5));
    }

    @Test
    public void whenSecond() {
        assertThat(Max.max(2, 6), is(6));
    }

    @Test
    public void whenThird() {
        assertThat(Max.max(10, 30, 50), is(50));
    }

    @Test
    public void whenFour() {
        assertThat(Max.max(5, 15, 30, 60), is(60));
    }

    @Test
    public void whenSame() {
        assertThat(Max.max(5, 5, 10, 10), is(10));
    }

    @Test
    public void whenSame1() {
        assertThat(Max.max(5, 10, 5, 10), is(10));
    }
}
