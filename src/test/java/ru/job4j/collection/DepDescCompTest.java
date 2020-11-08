package ru.job4j.collection;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class DepDescCompTest {

    @Test
    public void compare() {
        int rsl = new DepDescComp().compare(
                "K2/SK1/SSK2",
                "K2/SK1/SSK1"
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenUpDepartmentGoBefore() {
        int rsl = new DepDescComp().compare(
                "K2",
                "K2/SK1"
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenNaturalOrder() {
        List<String> result = Arrays.asList("K2","K2/SK1/SSK1","K2/SK1","K2/SK1/SSK2","K1"
                ,"K1/SK2","K1/SK1","K1/SK1/SSK2","K1/SK1/SSK1");
        List<String> expect = Arrays.asList("K1","K1/SK1","K1/SK1/SSK1","K1/SK1/SSK2","K1/SK2"
                ,"K2","K2/SK1","K2/SK1/SSK1","K2/SK1/SSK2");
        Departments.sortAsc(result);
        assertThat(result, is(expect));
    }
    @Test
    public void whenReverse() {
        List<String> result = Arrays.asList("K2","K2/SK1/SSK1","K2/SK1","K2/SK1/SSK2","K1"
                ,"K1/SK2","K1/SK1","K1/SK1/SSK2","K1/SK1/SSK1");
        List<String> expect = Arrays.asList("K2","K2/SK1","K2/SK1/SSK1","K2/SK1/SSK2"
                ,"K1","K1/SK1","K1/SK1/SSK1","K1/SK1/SSK2","K1/SK2");
        Departments.sortDesc(result);
        assertThat(result, is(expect));
    }
}