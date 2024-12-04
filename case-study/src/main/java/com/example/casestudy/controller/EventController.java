package com.example.casestudy.controller;

import com.example.casestudy.model.Event;
import com.example.casestudy.repo.Database;
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

@WebServlet(name = "eventController", urlPatterns = "/events")
public class EventController extends HttpServlet {
    private static IEventService eventService = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "";
        switch (action) {
            case "search":
                String name = req.getParameter("name");
                List<Event> searchResults = eventService.searchEventByName(name);
                req.setAttribute("events", searchResults);
                req.getRequestDispatcher("/WEB-INF/view/events.jsp").forward(req, resp);
                break;
            default:
                List<Event> events = eventService.getEvents();
                req.setAttribute("events", events);
                req.getRequestDispatcher("/WEB-INF/view/events.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        int id ;
//        String eventName;
//        LocalDate eventStart;
//        String imgEvent;
//        String location ;
//        String description;
//        Boolean isStatus ;
//        Integer ticketToSell;
//        if (action == null) action = "";
//        switch (action) {
//            case "delete":
//                id = Integer.parseInt(req.getParameter("id"));
//                eventService.deleteEvent(id);
//                resp.sendRedirect(req.getContextPath() + "/events");
//                break;
//            default:
//                eventName = req.getParameter("eventName");
//                eventStart = LocalDate.parse(req.getParameter("eventStart"));
//                imgEvent = req.getParameter("imgEvent");
//                location = req.getParameter("location");
//                description = req.getParameter("description");
//                isStatus = req.getParameter("isStatus").equals("1");
//                ticketToSell = Integer.parseInt(req.getParameter("ticketToSell"));
//                Event newEvent = new Event(eventName, eventStart, imgEvent, location, description, isStatus, ticketToSell);
//                eventService.addEvent(newEvent);
//                resp.sendRedirect(req.getContextPath() + "/events");
//                break;
        }
    }
