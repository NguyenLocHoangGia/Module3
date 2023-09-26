package com.codegym.bai_tap;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListCustomerServlet", value = "/ListCustomerServlet")
public class ListCustomerServlet extends HttpServlet {
    private static List<ListCustomer> list;
        static {
            list = new ArrayList<>();
            list.add(new ListCustomer(1,"Mai Văn Hoàn", "1983-08-20","Hà Nội"));
            list.add(new ListCustomer(2,"Nguyễn Văn Nam", "1983-08-21","Bắc Giang"));
            list.add(new ListCustomer(3,"Nguyễn Thái Hòa", "1983-08-22","Nam Định"));
            list.add(new ListCustomer(4,"Trần Đăng Khoa", "1983-08-23","Hà Tây"));
            list.add(new ListCustomer(5,"Nguyễn Đình Thi", "1983-08-24","Hà Nội"));
        }

    @Override
    public void init() throws ServletException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("listcustomer.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
