package com.codegym.casestudy.repository.impl;

import com.codegym.casestudy.database.DBRepository;
import com.codegym.casestudy.model.Customer_Type;
import com.codegym.casestudy.repository.IRepositoryId;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepo implements IRepositoryId {

    public static final String SELECT_TYPE_SERVICE = "SELECT * FROM customer_type; ";

    @Override
    public List findAll() {
        List<Customer_Type> list = new ArrayList<>();
        Customer_Type customerType;
        try {
            Connection connection = DBRepository.getConnection();
            Statement statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_TYPE_SERVICE);
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("customer_type_name");
                customerType = new Customer_Type(id, name);
                list.add(customerType);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
