package com.example.polimorfismo.models;

public class Estudiante {
    private String name;
    private String lasName;

    public Estudiante(String name, String lasName) {
        this.name = name;
        this.lasName = lasName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLasName() {
        return lasName;
    }

    public void setLasName(String lasName) {
        this.lasName = lasName;
    }

    @Override
    public String toString() {
        return name +
                "," + lasName;
    }
}
