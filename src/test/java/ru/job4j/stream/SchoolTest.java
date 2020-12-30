package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SchoolTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student("Surname1", 10));
        students.add(new Student("Surname2", 20));
        students.add(new Student("Surname3", 30));
        students.add(new Student("Surname4", 40));
        students.add(new Student("Surname5", 50));
        students.add(new Student("Surname6", 60));
        students.add(new Student("Surname7", 70));
        students.add(new Student("Surname8", 80));
        students.add(new Student("Surname9", 90));
    }

    @Test
    public void whenCollectClassA() {
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() >= 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Surname7", 70));
        expected.add(new Student("Surname8", 80));
        expected.add(new Student("Surname9", 90));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() >= 50 && student.getScore() < 70;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Surname5", 50));
        expected.add(new Student("Surname6", 60));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        School sc = new School();
        Predicate<Student> pr = student -> student.getScore() < 50;
        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student("Surname1", 10));
        expected.add(new Student("Surname2", 20));
        expected.add(new Student("Surname3", 30));
        expected.add(new Student("Surname4", 40));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenConvert() {
        School sc = new School();
        Map<String, Student> rsl = sc.convert(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put("Surname1", new Student("Surname1", 10));
        expected.put("Surname2", new Student("Surname2", 20));
        expected.put("Surname3", new Student("Surname3", 30));
        expected.put("Surname4", new Student("Surname4", 40));
        expected.put("Surname5", new Student("Surname5", 50));
        expected.put("Surname6", new Student("Surname6", 60));
        expected.put("Surname7", new Student("Surname7", 70));
        expected.put("Surname8", new Student("Surname8", 80));
        expected.put("Surname9", new Student("Surname9", 90));
        assertThat(rsl, is(expected));
    }
}