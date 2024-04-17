package com.example.polimorfismo.models;

import java.util.ArrayList;

public class DataBase3 implements SaveAndUpdate {
    private ArrayList<Estudiante> base3 = new ArrayList<>() ;

    @Override
    public void save(Estudiante student) {
        base3.add(student);
    }
    @Override
    public void update(Estudiante student) {
        for (int i = 0; i < base3.size(); i++) {
            if (base3.get(i).getName() == student.getName()) {
                base3.set(i, student);
                break;
            }
        }
    }
    @Override
    public ArrayList<Estudiante> getBase() {
        return new ArrayList<>(base3);
    }
}