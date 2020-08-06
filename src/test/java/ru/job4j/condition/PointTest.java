package ru.job4j.condition;

import org.junit.Assert;
import  org.junit.Test;;

public class PointTest {
    @Test
    public void distance3d() {
        Point a = new Point(3, 4, 6);
        Point b = new Point(5, 8, 10);
        Assert.assertEquals(6.000, a.distance(b), 0.001);
    }
    @Test
    public void distance() {
        Point a = new Point(8, 8);
        Point b = new Point(4, 4);
        Assert.assertEquals(5.656, a.distance(b), 0.001);

    }
    }