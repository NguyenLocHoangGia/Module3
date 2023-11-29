package com.example.thimodule3.Thue_tro.modle;

public class Hinh_thuc_thue {
    private int idThue;
    private String name;

    public Hinh_thuc_thue() {
    }

    public Hinh_thuc_thue(int idThue, String name) {
        this.idThue = idThue;
        this.name = name;
    }

    public int getIdThue() {
        return idThue;
    }

    public void setIdThue(int idThue) {
        this.idThue = idThue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
