package com.example.polimorfismo.models;

import java.util.ArrayList;

public class DataBase1 implements SaveAndUpdate {
    private ArrayList<Estudiante> base1 = new ArrayList<>();

    @Override
    public void save(Estudiante student) {
        base1.add(student);
    }
    @Override
    public void update(Estudiante student) {
        for (int i = 0; i < base1.size(); i++) {
            if (base1.get(i).getName() == student.getName()) {
                base1.set(i, student);
                break;
            }
        }
    }
    @Override
    public ArrayList<Estudiante> getBase() {
        return new ArrayList<>(base1);
    }
}
