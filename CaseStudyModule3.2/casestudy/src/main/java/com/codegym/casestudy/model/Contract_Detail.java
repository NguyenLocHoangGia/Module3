package com.codegym.casestudy.model;

public class Contract_Detail {
    private int idCD;
    private int idContract;
    private int idAttachService;
    private int quantity;

    public Contract_Detail(int idCD, int idContract, int idAttachService, int quantity) {
        this.idCD = idCD;
        this.idContract = idContract;
        this.idAttachService = idAttachService;
        this.quantity = quantity;
    }

    public int getIdCD() {
        return idCD;
    }

    public void setIdCD(int idCD) {
        this.idCD = idCD;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(int idAttachService) {
        this.idAttachService = idAttachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
