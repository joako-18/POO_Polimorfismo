package com.example.polimorfismo.models;

import java.util.List;

public interface SaveAndUpdate {
    void save(Estudiante student);
    void update(Estudiante student);
    List<Estudiante> getBase();
}
