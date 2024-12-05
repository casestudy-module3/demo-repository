package com.example.casestudy.controller;

import com.example.casestudy.model.Customer;
import com.example.casestudy.service.ICustomerService;
import com.example.casestudy.service.implement.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customerCotroller", value = "/customers")
public class CustomerController extends HttpServlet {
    private static ICustomerService customerService = new CustomerService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customers", customerList);
        request.getRequestDispatcher("WEB-INF/view/customer.jsp").forward(request, response);
    }
}
