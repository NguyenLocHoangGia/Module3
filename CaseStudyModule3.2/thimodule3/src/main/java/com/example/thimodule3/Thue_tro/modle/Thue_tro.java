package com.example.thimodule3.Thue_tro.modle;

import java.util.Date;

public class Thue_tro {
    private int id;
    private String name;
    private String numberphone;
    private Date startDay;
    private String note;

    public Thue_tro() {
    }

    public Thue_tro(int id, String name, String numberphone, Date startDay, String note) {
        this.id = id;
        this.name = name;
        this.numberphone = numberphone;
        this.startDay = startDay;
        this.note = note;
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

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
