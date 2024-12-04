package com.example.casestudy.controller;

import com.example.casestudy.model.Event;
import com.example.casestudy.service.IEventService;
import com.example.casestudy.service.implement.EventService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
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
        fileSizeThreshold = 1024 * 1024 * 2,  // 2MB
        maxFileSize = 1024 * 1024 * 10,       // 10MB
        maxRequestSize = 1024 * 1024 * 50     // 50MB
)
public class EventController extends HttpServlet {
    private static IEventService eventService = new EventService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
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
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        int id ;
        String eventName;
        LocalDate eventStart;
        String imgEvent=null;
        String location ;
        String description;
        Boolean isStatus ;
        Integer ticketToSell;
        if (action == null) action = "";
        switch (action) {
            case "delete":
                id = Integer.parseInt(req.getParameter("id"));
                eventService.deleteEvent(id);
                resp.sendRedirect(req.getContextPath() + "/events");
                break;
            case "update":

            case "add":
                eventName = req.getParameter("eventName");
                eventStart = LocalDate.parse(req.getParameter("eventStart"));
                imgEvent = req.getParameter("imgEvent");
                location = req.getParameter("location");
                description = req.getParameter("description");
                isStatus = req.getParameter("isStatus").equals("1");
                ticketToSell = Integer.parseInt(req.getParameter("ticketToSell"));
                Part filePart = req.getPart("imgEvent"); // Lấy file từ form
                if (filePart != null && filePart.getSize() > 0) {
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    String uploadDir = req.getServletContext().getRealPath("") + File.separator + "img";
                    File uploadDirFile = new File(uploadDir);
                    if (!uploadDirFile.exists()) {
                        uploadDirFile.mkdir(); // Tạo thư mục nếu chưa tồn tại
                    }

                    // Đường dẫn đầy đủ để lưu file
                    String fullFilePath = uploadDir + File.separator + fileName;
                    File file = new File(fullFilePath);
                    try (InputStream input = filePart.getInputStream()) {
                        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                    imgEvent = "img/" + fileName; // Đường dẫn để lưu vào cơ sở dữ liệu
                }
                Event newEvent = new Event(eventName, eventStart, imgEvent, location, description, isStatus, ticketToSell);
                eventService.addEvent(newEvent);
                resp.sendRedirect(req.getContextPath() + "/events");
                break;
        }
    }

}
