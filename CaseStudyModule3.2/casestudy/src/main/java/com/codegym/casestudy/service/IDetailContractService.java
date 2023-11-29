package com.codegym.casestudy.service;

import com.codegym.casestudy.model.Contract_Detail;

import java.util.List;

public interface IDetailContractService {
    List<Contract_Detail> finAll();
    void save(Contract_Detail contractDetail);
}
