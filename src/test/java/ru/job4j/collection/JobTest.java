package ru.job4j.collection;

import org.junit.Test;
import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority1() {
        Comparator<Job> cmpNamePriority = new CompareByNameDown().thenComparing(new CompareByPriorityUp());
        int rsl = cmpNamePriority.compare(
                new Job("B", 0),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenByNameUp() {
        Comparator<Job> cmpName = new CompareByNameUp();
        int rsl = cmpName.compare(
                new Job("A", 1),
                new Job("B", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenByNameDown() {
        Comparator<Job> cmpName = new CompareByNameDown();
        int rsl = cmpName.compare(
                new Job("B", 2),
                new Job("A", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenByPriorityUp() {
        Comparator<Job> cmpName = new CompareByPriorityUp();
        int rsl = cmpName.compare(
                new Job("A", 1),
                new Job("B", 2)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenByPriorityDown() {
        Comparator<Job> cmpName = new CompareByPriorityDown();
        int rsl = cmpName.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }
    @Test
    public void whenCompatorByNameAndPrority2() {
        Comparator<Job> cmpNamePriority = new CompareByNameUp().thenComparing(new CompareByPriorityDown());
        int rsl = cmpNamePriority.compare(
                new Job("A", 2),
                new Job("B", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}
