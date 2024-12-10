package com.example.casestudy.controller;

import com.example.casestudy.model.Customer;
import com.example.casestudy.service.ICustomerService;
import com.example.casestudy.service.implement.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "customerCotroller", value = "/customers")
public class CustomerController extends HttpServlet {
    private static ICustomerService customerService = new CustomerService();
    HttpSession session;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) action = "";
        session = request.getSession();
        boolean isInfor = (boolean) session.getAttribute("isInformation");
        switch (action) {
            case "search":
                if(isInfor){
                String name = request.getParameter("name");
                List<Customer> customerByName = customerService.findByName(name);
                request.setAttribute("customers", customerByName);
                request.getRequestDispatcher("WEB-INF/view/customer.jsp").forward(request, response);
                }else {
                   request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
                }
                break;
            default:
                if(isInfor){
                List<Customer> customerList = customerService.getAll();
                request.setAttribute("customers", customerList);
                request.getRequestDispatcher("WEB-INF/view/customer.jsp").forward(request, response);
                }else {
                    request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
                }
                break;

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if(action ==null) action = "";
        switch (action) {
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                Boolean status = Boolean.valueOf(req.getParameter("status"));
                customerService.delete(id, status);
                resp.sendRedirect(req.getContextPath() + "/customers");
                break;
        }
    }
}
