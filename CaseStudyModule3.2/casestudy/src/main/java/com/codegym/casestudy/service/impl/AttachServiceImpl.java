package com.codegym.casestudy.service.impl;

import com.codegym.casestudy.repository.IRepositoryId;
import com.codegym.casestudy.repository.impl.AttachServiceRepositori;
import com.codegym.casestudy.service.IServiceId;

import java.util.List;

public class AttachServiceImpl implements IServiceId {
  private IRepositoryId<AttachServiceImpl> iRepositoryId = new AttachServiceRepositori();
    @Override
    public List finall() {
        return null;
    }
}
