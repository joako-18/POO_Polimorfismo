package com.example.polimorfismo.models;

import java.util.ArrayList;
import java.util.List;

public class DataBase2 implements SaveAndUpdate {
    private ArrayList<Estudiante> base2 = new ArrayList<>();

    @Override
    public void save(Estudiante student) {
        base2.add(student);
    }
    @Override
    public void update(Estudiante student) {
        for (int i = 0; i < base2.size(); i++) {
            if (base2.get(i).getName() == student.getName()) {
                base2.set(i, student);
                break;
            }
        }
    }
    @Override
    public ArrayList<Estudiante> getBase() {
        return new ArrayList<>(base2);
    }
}
