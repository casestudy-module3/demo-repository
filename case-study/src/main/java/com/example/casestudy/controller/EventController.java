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
}
