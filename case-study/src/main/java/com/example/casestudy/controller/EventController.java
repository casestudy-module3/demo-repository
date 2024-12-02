package com.example.casestudy.controller;

import com.example.casestudy.model.Event;
import com.example.casestudy.service.IEventService;
import com.example.casestudy.service.implement.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name="eventController",urlPatterns = "/events")
public class EventController extends HttpServlet {
    private static IEventService eventService = new EventService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Event> events=eventService.getEvents();
        req.setAttribute("events", events);
        req.getRequestDispatcher("/WEB-INF/view/events.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            eventService.deleteEvent(id);
            resp.sendRedirect(req.getContextPath() + "/events");
        } else {
            String eventName = req.getParameter("eventName");
            LocalDate eventStart = LocalDate.parse(req.getParameter("eventStart"));
            String imgEvent = req.getParameter("imgEvent");
            String location = req.getParameter("location");
            String description = req.getParameter("description");
            Boolean isStatus = req.getParameter("isStatus").equals("1");
            Integer ticketToSell = Integer.parseInt(req.getParameter("ticketToSell"));
            Event newEvent = new Event(eventName, eventStart, imgEvent, location, description, isStatus, ticketToSell);
            eventService.addEvent(newEvent);
            resp.sendRedirect(req.getContextPath() + "/events");
        }
    }

}
