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
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?";
    private static final String UPDATE_CUSTOMER = "UPDATE customer SET customer_name=?, customer_birthday=?, customer_gender=?, customer_id_card=?, customer_phone=?, customer_email=?, customer_address=?, customer_type_id=? WHERE customer_id=?";
    private static final String FIND_BY_NAME = "SELECT customer.*, customer_type.customer_type_name\n" +
            "FROM customer\n" +
            "JOIN customer_type ON customer.customer_type_id = customer_type.customer_type_id\n" +
            "WHERE customer.customer_name LIKE ?;";
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
            preparedStatement.setDate(2, new java.sql.Date(customer.getBirthday().getTime()));
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

    @Override
    public List<Customer> searchCustomer(String name) {
        List<Customer> customers = new ArrayList<>();
        Connection connection = BaseRepo.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
            preparedStatement.setString(1,"%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()){
                int cID = resultSet.getInt("customer_id");
                String customerName = resultSet.getString("customer_name");
                Date date = resultSet.getDate("customer_birthday");
                Boolean gender = resultSet.getBoolean("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                String email = resultSet.getString("customer_email");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customer_type_name = resultSet.getString("customer_type_name");
                // tạo model
                CustomerType CustomerType = new CustomerType(customerTypeId,customer_type_name);
                customer = new Customer(cID,customerName,date,gender,idCard,phone,email,address,CustomerType);
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
/*
customer_name,
    customer_birthday,
    ,
    customer_id_card,
    customer_phone,
    customer_email,
    customer_address,
    customer_type_id
 */
    @Override
    public void updateCustomer(Customer customer) {
        Connection connection = BaseRepo.getConnection();
        try {
            // Cập nhật bảng customer
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER);
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setDate(2, new java.sql.Date(customer.getBirthday().getTime()));
            preparedStatement.setBoolean(3, customer.isGender());
            preparedStatement.setString(4, customer.getCustomerIDCard());
            preparedStatement.setString(5, customer.getPhone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getCustomerType().getCustomerTypeID());
            preparedStatement.setInt(9, customer.getCustomerID());
            preparedStatement.executeUpdate();

            // Cập nhật bảng customer_type thông qua SELECT với điều kiện JOIN
            preparedStatement = connection.prepareStatement("UPDATE customer_type " +
                    "SET customer_type_name = ? " +
                    "FROM customer_type " +
                    "JOIN customer ON customer_type.customer_type_id = customer.customer_type_id " +
                    "WHERE customer.customer_id = ?");
            preparedStatement.setString(1, customer.getCustomerType().getCustomerTypeName());
            preparedStatement.setInt(2, customer.getCustomerID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
