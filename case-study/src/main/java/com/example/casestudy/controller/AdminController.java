package com.example.casestudy.controller;

import com.example.casestudy.model.Admin;
import com.example.casestudy.model.Event;
import com.example.casestudy.service.IAdmin;
import com.example.casestudy.service.IEventService;
import com.example.casestudy.service.implement.AdminService;
import com.example.casestudy.service.implement.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "adminController", urlPatterns = "/logins")
public class AdminController extends HttpServlet {
    private static IAdmin iAdmin = new AdminService();
    private static IEventService iEventService = new EventService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
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
        }
    }
}
