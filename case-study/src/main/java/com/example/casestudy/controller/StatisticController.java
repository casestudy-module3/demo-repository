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

import com.google.gson.Gson;

@WebServlet(name = "statisticController", urlPatterns = {"/statistics", "/exportStatistics"})
public class StatisticController extends HttpServlet {
    private StatisticService statisticService = new StatisticService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("export".equals(action)) {
            exportStatistics(resp);
        } else if ("chartData".equals(action)) {
            sendChartData(resp);
        } else {
            req.setCharacterEncoding("UTF-8");
            Map<String, Integer> statisticsMap = statisticService.getStatisticsMap();
            req.setAttribute("statisticsMap", statisticsMap);
            req.getRequestDispatcher("/WEB-INF/view/statistic.jsp").forward(req, resp);
        }
    }

    private void exportStatistics(HttpServletResponse resp) throws IOException {
        Map<String, Integer> statisticsMap = statisticService.getStatisticsMap();

        try (org.apache.poi.ss.usermodel.Workbook workbook = new org.apache.poi.xssf.usermodel.XSSFWorkbook()) {
            int sheetIndex = 1;
            int itemCount = 0;
            org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Sheet " + sheetIndex);
            org.apache.poi.ss.usermodel.Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Title");
            headerRow.createCell(1).setCellValue("Value");
            int rowIndex = 1;
            for (Map.Entry<String, Integer> entry : statisticsMap.entrySet()) {
                if (itemCount >= 10) {
                    sheetIndex++;
                    sheet = workbook.createSheet("Sheet " + sheetIndex);
                    headerRow = sheet.createRow(0);
                    headerRow.createCell(0).setCellValue("Title");
                    headerRow.createCell(1).setCellValue("Value");
                    rowIndex = 1;
                    itemCount = 0;
                }
                org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(entry.getKey());
                row.createCell(1).setCellValue(entry.getValue());
                itemCount++;
            }
            resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            resp.setHeader("Content-Disposition", "attachment; filename=statistics.xlsx");

            try (java.io.OutputStream outputStream = resp.getOutputStream()) {
                workbook.write(outputStream);
            }
        }
    }

    private void sendChartData(HttpServletResponse resp) throws IOException {
        Map<String, Integer> statisticsMap = statisticService.getStatisticsMap2();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        String json = gson.toJson(statisticsMap);
        PrintWriter writer = resp.getWriter();
        writer.println(json);
        writer.flush();
        writer.close();
    }
}