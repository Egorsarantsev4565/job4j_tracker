package ru.job4j.collection;
import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int res = Character.compare(o2.charAt(1), o1.charAt(1));
        if (res == 0) {
            res = o1.compareTo(o2);

        }
        return res;
    }
}
