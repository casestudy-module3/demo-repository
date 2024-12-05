package com.example.casestudy.repo;

import com.example.casestudy.model.Statistic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

public class StatisticRepo {
    public Statistic getStatistics() {
        int totalEvents = 0;
        int totalTicketsSold = 0;
        int totalActiveEvents = 0;

        try {
            PreparedStatement totalEventsStmt = Database.getConnection().prepareStatement("SELECT COUNT(*) FROM events_organized");
            ResultSet resultSet = totalEventsStmt.executeQuery();
            if (resultSet.next()) {
                totalEvents = resultSet.getInt(1);
            }

            PreparedStatement totalTicketsSoldStmt = Database.getConnection().prepareStatement("SELECT SUM(scope) FROM events_organized WHERE status_event = true");
            resultSet = totalTicketsSoldStmt.executeQuery();
            if (resultSet.next()) {
                totalTicketsSold = resultSet.getInt(1);
            }

            PreparedStatement totalActiveEventsStmt = Database.getConnection().prepareStatement("SELECT COUNT(*) FROM events_organized WHERE status_event = true");
            resultSet = totalActiveEventsStmt.executeQuery();
            if (resultSet.next()) {
                totalActiveEvents = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching statistics", e);
        }

        return new Statistic(totalEvents, totalTicketsSold, totalActiveEvents);
    }

    public Map<String, Integer> getStatisticsMap() {
        Map<String, Integer> statisticsMap = new LinkedHashMap<>();
        Statistic statistic = getStatistics();
        statisticsMap.put("Total Events", statistic.getTotalEvents());
        statisticsMap.put("Total Tickets Sold", statistic.getTotalTicketsSold());
        statisticsMap.put("Total Active Events", statistic.getTotalActiveEvents());
        return statisticsMap;
    }
}
