package com.siddy.apilab1.model;

public class Coffee {
    private final String name;
    private final int id;

    public Coffee(String name, int id){
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
