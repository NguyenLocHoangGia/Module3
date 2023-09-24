package com.codegym.productdiscountcalculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculator", value = "/product")

public class productdiscountcalculator extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float percent = Float.parseFloat(req.getParameter("percent"));
        float price = Float.parseFloat(req.getParameter("price"));

        float amount = (float) (price * percent * 0.01);

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<h1>Price: " + price + "</h1>");
        writer.println("<h1>Percent: " + percent + "</h1>");
        writer.println("<h1>Amount: " + amount + "</h1>");
        writer.println("</html>");
    }
}
