package ru.job4j.poly;

public interface Transport {
    void drive();
   void seat(int passenger);
    int refill(int fuel, int value);
}
