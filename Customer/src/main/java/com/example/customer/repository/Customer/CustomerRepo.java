package com.example.customer.repository.Customer;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerType;
import com.example.customer.repository.BaseRepo;
import com.example.customer.repository.CustomerType.CustomerTypeRepo;
import com.example.customer.repository.CustomerType.ICustomerTypeRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepo implements ICustomerRepo{
    private ICustomerTypeRepo iCustomerTypeRepo = new CustomerTypeRepo();
    private static final String SELECT_CUSTOMER = "SELECT \n" +
            "    c.*,\n" +
            "    ct.customer_type_name\n" +
            "FROM \n" +
            "    customer c\n" +
            "JOIN \n" +
            "    customer_type ct ON c.customer_type_id = ct.customer_type_id;";
    private static final String INSERT_INTO_CUSTOMER = "INSERT INTO Customer (\n" +
            "    customer_name, \n" +
            "    customer_birthday, \n" +
            "    customer_gender, \n" +
            "    customer_id_card, \n" +
            "    customer_phone, \n" +
            "    customer_email, \n" +
            "    customer_address, \n" +
            "    customer_type_id\n" +
            ") VALUES(?,?,?,?,?,?,?,?)";
    private static final String DELETE_CUSTOMER = "delete from customer where id = ?";

    @Override
    public List<Customer> showListCustomer() {
        List<Customer> list = new ArrayList<>();
        CustomerType customerType = null;
        Connection connection = BaseRepo.getConnection();
        Customer customer = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_CUSTOMER);
            while (resultSet.next()){
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                Boolean gender = resultSet.getBoolean("customer_gender");
                Date birthday = resultSet.getDate("customer_birthday");
                String id_card = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String email = resultSet.getString("customer_email");
                String address = resultSet.getString("customer_address");
                // lấy ra customer type
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customer_type_name = resultSet.getString("customer_type_name");
                // tạo model
                CustomerType CustomerType = new CustomerType(customerTypeId,customer_type_name);
                Customer Customer = new Customer(id,name,birthday,gender,id_card,phone,email,address,CustomerType);

                //thêm vào list
                list.add(Customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
/*
customer_name,
    customer_birthday,
    customer_gender,
    customer_id_card,
    customer_phone,
    customer_email,
    customer_address,
    customer_type_id
 */
    @Override
    public void addCustomer(Customer customer) {
        try {
            PreparedStatement preparedStatement = BaseRepo.getConnection().prepareStatement(INSERT_INTO_CUSTOMER);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setDate(2, (java.sql.Date) customer.getBirthday());
            preparedStatement.setBoolean(3,customer.isGender());
            preparedStatement.setString(4,customer.getCustomerIDCard());
            preparedStatement.setString(5,customer.getPhone());
            preparedStatement.setString(6,customer.getEmail());
            preparedStatement.setString(7,customer.getAddress());
            preparedStatement.setInt(8,customer.getCustomerType().getCustomerTypeID());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        try {
            PreparedStatement preparedStatement = BaseRepo.getConnection().prepareStatement(DELETE_CUSTOMER);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
