package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {

        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {

        Predicate<Person> name = (param) -> param.getName().contains(key);
        Predicate<Person> surname = (param) -> param.getSurname().contains(key);
        Predicate<Person> phone = (param) -> param.getPhone().contains(key);
        Predicate<Person> address = (param) -> param.getAddress().contains(key);

        Predicate<Person> combine = name.or(surname).or(phone).or(address);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    }
