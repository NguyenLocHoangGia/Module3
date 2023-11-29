package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.Attach_Service;
import com.codegym.casestudy.model.Customer;
import com.codegym.casestudy.repository.IRepositoryId;
import com.codegym.casestudy.repository.impl.CustomerTypeRepo;
import com.codegym.casestudy.service.ICustomerService;
import com.codegym.casestudy.service.IDetailContractService;
import com.codegym.casestudy.service.IServiceId;
import com.codegym.casestudy.service.impl.CustomerServiceImpl;
import com.codegym.casestudy.service.impl.DetailContractServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", value = "/customer-servlet")
public class CustomerServlet extends HttpServlet {
    private ICustomerService iCustomerService = new CustomerServiceImpl();
    private IRepositoryId iRepositoryId = new CustomerTypeRepo();
    private IDetailContractService iDetailContractService = new DetailContractServiceImpl();
    private IServiceId<Attach_Service> attachService;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "edit":
                break;
            case "delete":
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case  "edit":
                break;
            case  "delete":
                break;

        }
    }
    private void showCreateForm (HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.iCustomerService.findId(id);
        RequestDispatcher dispatcher;
        if (customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer",customer);
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
