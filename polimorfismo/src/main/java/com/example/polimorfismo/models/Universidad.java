package com.example.polimorfismo.models;

public class Universidad {
    DataBase1 base1;
    DataBase2 base2;
    DataBase3 base3;

    public Universidad(DataBase1 base1, DataBase2 base2, DataBase3 base3) {
        this.base1 = new DataBase1();
        this.base2 = new DataBase2();
        this.base3 = new DataBase3();
    }

    public DataBase1 getBase1() {
        return base1;
    }

    public DataBase2 getBase2() {
        return base2;
    }

    public DataBase3 getBase3() {
        return base3;
    }
}
