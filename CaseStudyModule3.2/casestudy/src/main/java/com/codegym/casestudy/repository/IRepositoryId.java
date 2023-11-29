package com.codegym.casestudy.repository;

import java.util.List;

public interface IRepositoryId<E> {
    List<E> findAll();
}
