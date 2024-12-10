package com.example.casestudy.controller;

import com.example.casestudy.model.Event;
import com.example.casestudy.service.IEventService;
import com.example.casestudy.service.implement.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "eventController", urlPatterns = "/events")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class EventController extends HttpServlet {
    private static IEventService eventService = new EventService();
    HttpSession session;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        session = req.getSession();
        session.getAttribute("isInformation");
        boolean isInfor = (boolean) session.getAttribute("isInformation");
        if (action == null) action = "";
        switch (action) {
            case "search":
                if(isInfor){
                String name = req.getParameter("name");
                List<Event> searchResults = eventService.searchEventByName(name);
                req.setAttribute("events", searchResults);
                req.getRequestDispatcher("/WEB-INF/view/events.jsp").forward(req, resp);
                }else {
                    req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
                }
                break;
            case "edit":
                if(isInfor){
                req.getRequestDispatcher("/WEB-INF/view/events.jsp").forward(req, resp);
                 }else {
                        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
                    }
                break;

            default:
                if(isInfor){
                List<Event> events = eventService.getEvents();
                req.setAttribute("events", events);
                req.getRequestDispatcher("/WEB-INF/view/events.jsp").forward(req, resp);
                }else {
                    req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        session = req.getSession();
        session.getAttribute("isInformation");
        boolean isInformation = false;
        if (session.getAttribute("isInformation") != null) {
             isInformation = (boolean) session.getAttribute("isInformation");
        }

        int id;
        String eventName;
        LocalDate eventStart;
        String imgEvent = null;
        String location;
        String description;
        Boolean isStatus;
        Integer ticketToSell;
        if (action == null) action = "";
        switch (action) {
            case "delete":
                if(isInformation){
                id = Integer.parseInt(req.getParameter("id"));
                eventService.deleteEvent(id);
                resp.sendRedirect(req.getContextPath() + "/events");
                }else {
                    req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
                }
                break;
            case "edit":
                if(isInformation){
                id = Integer.parseInt(req.getParameter("id"));
                String name = req.getParameter("eventName");
                LocalDate date = LocalDate.parse(req.getParameter("eventStart"));
                imgEvent = req.getParameter("imgEvent");
                location = req.getParameter("location");
                description = req.getParameter("description");
                isStatus = Boolean.parseBoolean(req.getParameter("status"));
                ticketToSell = Integer.parseInt(req.getParameter("ticketToSell"));
                Part files = req.getPart("imgEvent");
                if (files != null && files.getSize() > 0) {
                    String fileName = Paths.get(files.getSubmittedFileName()).getFileName().toString();
                    String uploadDir = req.getServletContext().getRealPath("") + File.separator + "img";
                    File uploadDirFile = new File(uploadDir);
                    if (!uploadDirFile.exists()) {
                        uploadDirFile.mkdir();
                    }
                    String fullFilePath = uploadDir + File.separator + fileName;
                    File file = new File(fullFilePath);
                    try (InputStream input = files.getInputStream()) {
                        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                    imgEvent = "img/" + fileName;
                }
                Event changeEvent = new Event(name, date, imgEvent, location, description, isStatus, ticketToSell);
                eventService.updateEvent(id, changeEvent);
                resp.sendRedirect(req.getContextPath() + "/events");
                }else {
                        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
                        }
                break;
            case "add":
                if(isInformation){
                eventName = req.getParameter("eventName");
                eventStart = LocalDate.parse(req.getParameter("eventStart"));
                imgEvent = req.getParameter("imgEvent");
                location = req.getParameter("location");
                description = req.getParameter("description");
                isStatus = req.getParameter("isStatus").equals("1");
                ticketToSell = Integer.parseInt(req.getParameter("ticketToSell"));
                Part filePart = req.getPart("imgEvent");
                if (filePart != null && filePart.getSize() > 0) {
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    String uploadDir = req.getServletContext().getRealPath("") + File.separator + "img";
                    File uploadDirFile = new File(uploadDir);
                    if (!uploadDirFile.exists()) {
                        uploadDirFile.mkdir();
                    }
                    String fullFilePath = uploadDir + File.separator + fileName;
                    File file = new File(fullFilePath);
                    try (InputStream input = filePart.getInputStream()) {
                        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                    imgEvent = "img/" + fileName;
                }
                Event newEvent = new Event(eventName, eventStart, imgEvent, location, description, isStatus, ticketToSell);
                eventService.addEvent(newEvent);
                resp.sendRedirect(req.getContextPath() + "/events");
                }else {
                    req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
                }
                break;
        }
    }

}
