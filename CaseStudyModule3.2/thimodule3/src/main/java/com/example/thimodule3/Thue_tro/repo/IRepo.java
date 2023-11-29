package com.example.thimodule3.Thue_tro.repo;

import com.example.thimodule3.Thue_tro.modle.Thue_tro;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IRepo {
    List<Thue_tro> finAll = null;
    Thue_tro findById (int id);
    boolean remove(int id) throws SQLException;
    boolean update (Thue_tro thue_tro) throws  SQLException;
    boolean add(Thue_tro thue_tro) throws SQLException;
    List <Thue_tro> showBy(String id, Date statrDay, String numberphone, String name);
    }
