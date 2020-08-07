package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item() {
    }
    public Item(int id) {
 id = 5;
    }

    public Item(int id, String name) {
        name = "Egor";
        id = 5;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}