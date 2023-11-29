package com.codegym.casestudy.model;

public class Attach_Service {
    private int idAS;
    private String nameAS;
    private double costAS;
    private int unitAS;
    private String statusAS;

    public Attach_Service(int idAS, String nameAS, double costAS, int unitAS, String statusAS) {
        this.idAS = idAS;
        this.nameAS = nameAS;
        this.costAS = costAS;
        this.unitAS = unitAS;
        this.statusAS = statusAS;
    }

    public int getIdAS() {
        return idAS;
    }

    public void setIdAS(int idAS) {
        this.idAS = idAS;
    }

    public String getNameAS() {
        return nameAS;
    }

    public void setNameAS(String nameAS) {
        this.nameAS = nameAS;
    }

    public double getCostAS() {
        return costAS;
    }

    public void setCostAS(double costAS) {
        this.costAS = costAS;
    }

    public int getUnitAS() {
        return unitAS;
    }

    public void setUnitAS(int unitAS) {
        this.unitAS = unitAS;
    }

    public String getStatusAS() {
        return statusAS;
    }

    public void setStatusAS(String statusAS) {
        this.statusAS = statusAS;
    }
}
