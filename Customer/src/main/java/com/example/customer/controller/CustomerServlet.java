package com.example.customer.controller;

import com.example.customer.model.Customer;
import com.example.customer.model.CustomerType;
import com.example.customer.repository.Customer.CustomerRepo;
import com.example.customer.repository.Customer.ICustomerRepo;
import com.example.customer.repository.CustomerType.CustomerTypeRepo;
import com.example.customer.repository.CustomerType.ICustomerTypeRepo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

private ICustomerRepo iCustomerRepo = new CustomerRepo();
private ICustomerTypeRepo iCustomerTypeRepo = new CustomerTypeRepo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(req,resp);
                break;
            default:
                showListCustomer(req,resp);
        }
    }

    private void showListCustomer(HttpServletRequest req, HttpServletResponse resp) {
        List<Customer> list= iCustomerRepo.showListCustomer();
        req.setAttribute("list",list);
        try {
            req.getRequestDispatcher("/list-customer.jsp").forward(req,resp);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) {
        List<CustomerType> list = iCustomerTypeRepo.showListCustomerType();
        req.setAttribute("list", list);
        try {
            req.getRequestDispatcher("/create.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action){
            case "create":
                create(req,resp);
                break;
            case "delete":
                delete(req,resp);
                break;
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("idDel"));
        iCustomerRepo.deleteCustomer(id);
        try {
            resp.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void create(HttpServletRequest req, HttpServletResponse resp) {
    String customerName = req.getParameter("name");
    String birthday = req.getParameter("date");
        Date date = null;
        try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
            date = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    Boolean gender = Boolean.valueOf(req.getParameter("gender"));
        String idCard = req.getParameter("idCard");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        int ctID = Integer.parseInt(req.getParameter("ctID"));
        CustomerType customerType = iCustomerTypeRepo.findCustomerType(ctID);

        Customer customer = new Customer(-1,customerName,date,gender,idCard,phone,email,address,customerType);
        iCustomerRepo.addCustomer(customer);
        try {
            resp.sendRedirect("/customer");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
