package com.example.casestudy.controller;


import com.example.casestudy.service.implement.StatisticService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "statisticController", urlPatterns = {"/statistics", "/exportStatistics"})
public class StatisticController extends HttpServlet {
    private StatisticService statisticService = new StatisticService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("export".equals(action)) {
            exportStatistics(resp);
        } else {
            req.setCharacterEncoding("UTF-8");
            Map<String, Integer> statisticsMap = statisticService.getStatisticsMap();
            req.setAttribute("statisticsMap", statisticsMap);
            req.getRequestDispatcher("/WEB-INF/view/statistic.jsp").forward(req, resp);
        }
    }

    private void exportStatistics(HttpServletResponse resp) throws IOException {
        Map<String, Integer> statisticsMap = statisticService.getStatisticsMap();

        resp.setContentType("text/csv");
        resp.setHeader("Content-Disposition", "attachment; filename=statistics.csv");

        PrintWriter writer = resp.getWriter();
        writer.println("Title,Value");
        for (Map.Entry<String, Integer> entry : statisticsMap.entrySet()) {
            writer.println(entry.getKey() + "," + entry.getValue());
        }
        writer.flush();
        writer.close();
    }
}