package ru.job4j.ex;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenFact1() {
        int rsl = Fact.calc(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void whenFact2() {
        int rsl = Fact.calc(-3);
    }
    @Test
    public void whenFact3() {
        int rsl = Fact.calc(2);
        int expected = 2;
        assertThat(expected, is(rsl));
    }
}