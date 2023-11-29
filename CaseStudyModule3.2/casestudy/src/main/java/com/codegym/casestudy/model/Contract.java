package com.codegym.casestudy.model;

public class Contract {
    private int id;
    private String startdate;
    private String enddate;
    private double depositContract;
    private double totalMoney;
    private int employeeId;
    private int customerId;
    private int serviceId;

    public Contract(int id, String startdate, String enddate, double depositContract, double totalMoney, int employeeId, int customerId, int serviceId) {
        this.id = id;
        this.startdate = startdate;
        this.enddate = enddate;
        this.depositContract = depositContract;
        this.totalMoney = totalMoney;
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.serviceId = serviceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    public double getDepositContract() {
        return depositContract;
    }

    public void setDepositContract(double depositContract) {
        this.depositContract = depositContract;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }
}
