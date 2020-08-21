package ru.job4j.poly;

public class Bus implements Transport {
    private int passenger;




    @Override
    public void drive() {
        System.out.println("The transport is in motion");
    }

    @Override
    public void seat(int passenger) {
        this.passenger = passenger;
    }

    @Override
    public int refill(int fuel, int value) {
         fuel = 80;
         value = 45;
        return fuel * value;
    }
}
