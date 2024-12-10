package com.example.casestudy.controller;

import com.example.casestudy.repo.EmailSender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MailController", urlPatterns = "/sendMail")
public class MailController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String eventName = req.getParameter("eventName");
        String ticketsNumber = req.getParameter("ticketsNumber");

        String subject = "Payment Confirmation";
        String content = "Dear " + name + ",\n\nYour payment has been successfully received.\n\nEvent: " + eventName +
                "\nTickets: " + ticketsNumber + "\n\nThank you!";
        HttpSession session = req.getSession();
        boolean isInfor = false;
        if (session.getAttribute("isInformation") != null) {
            isInfor = (boolean) session.getAttribute("isInformation");
        }
        if(isInfor){
            try {
                EmailSender.sendEmail(email, subject, content);
                req.getSession().setAttribute("message", "Email sent successfully to " + email + ".");
                req.getSession().setAttribute("alertType", "success");
            } catch (Exception e) {
                req.getSession().setAttribute("message", "Failed to send email. Please try again.");
                req.getSession().setAttribute("alertType", "danger");
            }

            resp.sendRedirect(req.getContextPath() + "/customers?action=customers");
        }else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        }
    }
}
