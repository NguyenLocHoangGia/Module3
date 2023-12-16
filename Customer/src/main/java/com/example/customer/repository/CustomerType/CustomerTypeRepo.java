package com.example.customer.repository.CustomerType;

import com.example.customer.model.CustomerType;
import com.example.customer.repository.BaseRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepo implements ICustomerTypeRepo{
    private static final String SELCET_ALL = "select * from customer_type;";
    private static final String FIND_ID_CT = "select * from customer_type where customer_type_id = ?;";
    @Override
    public List<CustomerType> showListCustomerType() {
        List<CustomerType> list = new ArrayList<>();
        Connection connection = BaseRepo.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELCET_ALL);
            while (resultSet.next()){
                int ctID = resultSet.getInt("customer_type_id");
                String ctName = resultSet.getString("customer_type_name");
                CustomerType customerType = new CustomerType(ctID,ctName);
                list.add(customerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public CustomerType findCustomerType(int id) {
        CustomerType customerType = null;
        try {
            PreparedStatement preparedStatement = BaseRepo.getConnection().prepareStatement(FIND_ID_CT);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int ctID =  resultSet.getInt("customer_type_id");
                String ctName = resultSet.getString("customer_type_id");
                customerType = new CustomerType(ctID,ctName);
            }
            return customerType;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
