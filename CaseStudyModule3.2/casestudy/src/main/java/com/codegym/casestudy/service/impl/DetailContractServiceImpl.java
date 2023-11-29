package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.model.Contract_Detail;
import com.codegym.casestudy.service.IDetailContractService;

import java.util.List;

public class DetailContractServiceImpl implements IDetailContractService {
    private IDetailContractService iDetailContractService = new DetailContractServiceImpl();
    @Override
    public List<Contract_Detail> finAll() {
        return iDetailContractService.finAll();
    }

    @Override
    public void save(Contract_Detail contractDetail) {
        iDetailContractService.save(contractDetail);
    }
}
