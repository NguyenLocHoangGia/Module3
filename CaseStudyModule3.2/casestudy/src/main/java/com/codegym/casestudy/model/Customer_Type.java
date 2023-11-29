package com.codegym.casestudy.model;

public class Customer_Type {
    private int idCustomerType;
    private String name;

    public Customer_Type(int idCustomerType, String name) {
        this.idCustomerType = idCustomerType;
        this.name = name;
    }

    public int getIdCustomerType() {
        return idCustomerType;
    }

    public void setIdCustomerType(int idCustomerType) {
        this.idCustomerType = idCustomerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
