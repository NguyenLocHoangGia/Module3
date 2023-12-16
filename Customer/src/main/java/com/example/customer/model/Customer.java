package com.example.customer.model;

import java.util.Date;

public class Customer {
    private int CustomerID;
    private String CustomerName;
    private Date Birthday;
    private boolean Gender;
    private String CustomerIDCard;
    private String Phone;
    private String Email;
    private String Address;
    private CustomerType customerType;

    public Customer() {
    }

    public Customer(int customerID, String customerName, Date birthday, boolean gender, String customerIDCard, String phone, String email, String address, CustomerType customerType) {
        CustomerID = customerID;
        CustomerName = customerName;
        Birthday = birthday;
        Gender = gender;
        CustomerIDCard = customerIDCard;
        Phone = phone;
        Email = email;
        Address = address;
        this.customerType = customerType;
    }

    public Customer(String customerName, Date birthday, boolean gender, String customerIDCard, String phone, String email, String address, CustomerType customerType) {
        CustomerName = customerName;
        Birthday = birthday;
        Gender = gender;
        CustomerIDCard = customerIDCard;
        Phone = phone;
        Email = email;
        Address = address;
        this.customerType = customerType;
    }

    public Customer(int customerID, String customerName, CustomerType customerType) {
        CustomerID = customerID;
        CustomerName = customerName;
        this.customerType = customerType;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public String getCustomerIDCard() {
        return CustomerIDCard;
    }

    public void setCustomerIDCard(String customerIDCard) {
        CustomerIDCard = customerIDCard;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
