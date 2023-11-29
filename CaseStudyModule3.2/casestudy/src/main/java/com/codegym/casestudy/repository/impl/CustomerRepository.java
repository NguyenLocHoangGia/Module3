package com.codegym.casestudy.repository.impl;

import com.codegym.casestudy.database.DBRepository;
import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.repository.ICustomerRepositori;
import com.codegym.casestudy.service.ICustomerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerRepository implements ICustomerRepositori {

    public static final String SELECT_CUSTOMER = " SELECT * FROM customer;";
    public static final String INSERT_CUSTOMER = "INSERT INTO `customer` (`customer_name`, `customer_birthday`, `customer_gender`, `customer_id_card`, `customer_phone`, `customer_email`, `customer_address`, `customer_type_id`) VALUES (?,?,?,?,?,?,?,?);";
    public static final String SELECT_CUSTOMER_WHERE_ID = "SELECT * FROM customer where customer_id=?";
    public static final String UPDATE = "UPDATE `customer` SET `customer_name` = ? ,`customer_birthday` = ?, `customer_gender` = ?, `customer_id_card` = ?, `customer_phone` = ?, `customer_email` =?, `customer_address` = ?, `customer_type_id` = ? WHERE (`customer_id` = ?);";
    public static final String DELETE = "call delete_customer(?) ";
    public static final String SELECT_CUSTOMER_WHERE_NAME = "SELECT * FROM customer where `customer_name` like ?;";


    private CustomerRepository customerRepository;
    @Override
    public List<Customer> finAll() {
        List<Customer> list = new ArrayList<>();
        Customer customer;
        try {
            Connection connection = DBRepository.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_CUSTOMER);
            while (resultSet.next()){
                int id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                Date birthDay = resultSet.getDate("customer_birthday");
                Boolean gender = resultSet.getBoolean("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String email = resultSet.getString("customer_email");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                int idTypeCustomer = resultSet.getInt("customer_type_id");
                customer = new Customer(id, idTypeCustomer, name, birthDay, gender, idCard, phone, email, address);
                list.add(customer);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Customer> findName() {
        Customer customer;
        List<Customer> list = new ArrayList<>();
        try {
            Connection connection = DBRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customer where ;");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        try {
            Connection connection = DBRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER);
            preparedStatement.setString(1, customer.getName());
//            preparedStatement.setDate(2, customer.getBirthDay());
            Date sqlDate = new Date(customer.getBirthday().getTime());
            preparedStatement.setDate(2, (java.sql.Date) sqlDate);
            preparedStatement.setBoolean(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getNumberphone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getIdCustomerType());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findById(int id) {
        System.out.println("id " + id);
        Customer customer = null;
        try {
            Connection connection = DBRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_WHERE_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("customer_id");
                String name = resultSet.getString("customer_name");
                Date birthDay = resultSet.getDate("customer_birthday");
                Boolean gender = resultSet.getBoolean("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String email = resultSet.getString("customer_email");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                int idTypeCustomer = resultSet.getInt("customer_type_id");
                customer = new Customer(id, idTypeCustomer, name, birthDay, gender, idCard, phone, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> list = new ArrayList<>();
        Customer customer;
        try {
            Connection connection = DBRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_WHERE_NAME);
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                name = resultSet.getString("customer_name");
                Date birthDay = resultSet.getDate("customer_birthday");
                Boolean gender = resultSet.getBoolean("customer_gender");
                String idCard = resultSet.getString("customer_id_card");
                String email = resultSet.getString("customer_email");
                String phone = resultSet.getString("customer_phone");
                String address = resultSet.getString("customer_address");
                int idTypeCustomer = resultSet.getInt("customer_type_id");
                customer = new Customer(id, idTypeCustomer, name, birthDay, gender, idCard, phone, email, address);
                list.add(customer);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public Boolean update(Customer customer) {
        Boolean rowUpdate = false;
        try {
//`name_customer` = ? `day_of_birth` = ?, `gender` = ?, `customer_code` = ?, `phone_number` = ?, `email` =?,
// `address` = ?, `type_customer_id` = ? WHERE (`customer_id` = ?);
            Connection connection = DBRepository.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1, customer.getName());

            preparedStatement.setDate(2, (java.sql.Date) customer.getBirthday());
            preparedStatement.setBoolean(3, customer.getGender());
            preparedStatement.setString(4, customer.getIdCard());
            preparedStatement.setString(5, customer.getNumberphone());
            preparedStatement.setString(6, customer.getEmail());
            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(8, customer.getIdCustomerType());
            preparedStatement.setInt(9, customer.getId());
            rowUpdate = preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(rowUpdate);
        return rowUpdate;
    }

    @Override
    public Boolean delete(int  id) {
        Boolean rowDelete = false;
        try {
            Customer customer = customerRepository.findById(id);
            Connection connection = DBRepository.getConnection();
            CallableStatement CallableStatement = connection.prepareCall(DELETE);
            CallableStatement.setInt(1, customer.getId());
            rowDelete = CallableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }
}
