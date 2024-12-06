package com.example.casestudy.controller;

import com.example.casestudy.model.Admin;
import com.example.casestudy.model.Event;
import com.example.casestudy.service.IAdmin;
import com.example.casestudy.service.IEventService;
import com.example.casestudy.service.implement.AdminService;
import com.example.casestudy.service.implement.EventService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "adminController", urlPatterns = {"/logins", "/adminProfile"})
//@WebServlet(name = "adminController", urlPatterns = "/logins")
public class AdminController extends HttpServlet {
    private static IAdmin iAdmin = new AdminService();
    private static IEventService iEventService = new EventService();
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

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        System.out.println(action);
        if("login".equals(action)){
            String userName = req.getParameter("user_name");
            String password = req.getParameter("password");
            Admin admin = new Admin(userName, password);
            boolean isInformation = iAdmin.checkInformation(admin);
            if(isInformation){
                req.setAttribute("message", "Login successfully");
                List<Event> eventList = iEventService.getEvents();
                req.setAttribute("events", eventList);
                req.getRequestDispatcher("/WEB-INF/view/events.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "Invalid username or password");
                req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
            }
        } else if ("sign_out".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        } else if ("save".equals(action)) {
            String name = req.getParameter("fullName");
            LocalDate dob = LocalDate.parse(req.getParameter("dob"));
            Boolean gender = Boolean.valueOf(req.getParameter("gender"));
            String address = req.getParameter("address");
            String phone = req.getParameter("phone");
            Admin newInformationAdmin = new Admin(name, dob, gender, address, phone);
            iAdmin.updateInformation(newInformationAdmin);
            resp.sendRedirect(req.getContextPath() + "/adminProfile");
        }
    }
}
