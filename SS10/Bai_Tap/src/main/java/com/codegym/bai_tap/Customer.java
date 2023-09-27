package com.codegym.bai_tap;

public class Customer {
    int id;
    String name;
    String DayOfBirthd;
    String address;

    public Customer(int id, String name, String dayOfBirthd, String address) {
        this.id = id;
        this.name = name;
        DayOfBirthd = dayOfBirthd;
        this.address = address;
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

    public String getDayOfBirthd() {
        return DayOfBirthd;
    }

    public void setDayOfBirthd(String dayOfBirthd) {
        DayOfBirthd = dayOfBirthd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
