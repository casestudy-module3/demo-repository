package com.example.casestudy.controller;

import com.example.casestudy.model.Admin;
import com.example.casestudy.service.implement.AdminService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "AdminController", value = "/adminProfile")
public class AdminController extends HttpServlet {
    private AdminService adminService = new AdminService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            List<Admin> admins = adminService.getAdmin();
            req.setAttribute("admin", admins);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/adminProfile.jsp");
            dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

