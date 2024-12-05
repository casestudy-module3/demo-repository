package com.example.casestudy.repo;

import com.example.casestudy.model.Event;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventRepo {
    private static List<Event> events = new ArrayList<>();

    public List<Event> getEvents() {
        events.clear();
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement("SELECT * FROM events_organized");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nameEvent = resultSet.getString("name_event");
                String place = resultSet.getString("place");
                LocalDate timeEvent = resultSet.getDate("time_event").toLocalDate();
                String image = resultSet.getString("image");
                Integer scope = resultSet.getInt("scope");
                String descriptionEvent = resultSet.getString("description_event");
                Boolean statusEvent = resultSet.getBoolean("status_event");
                events.add(new Event(id, nameEvent, timeEvent, image, place, descriptionEvent, statusEvent, scope));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching events", e);
        }
        return events;
    }

    public void addEvent(Event event) {
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(
                    "INSERT INTO events_organized (name_event, time_event, image, place, description_event, status_event, scope) VALUES (?, ?, ?, ?, ?, ?, ?)"
            );
            statement.setString(1, event.getEventName());
            statement.setDate(2, java.sql.Date.valueOf(event.getEventStart()));
            statement.setString(3, event.getImgEvent());
            statement.setString(4, event.getLocation());
            statement.setString(5, event.getDescription());
            statement.setBoolean(6, event.getIsStatus());
            statement.setInt(7, event.getTicketToSell());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error adding event", e);
        }
    }

    public void deleteEvent(Integer id) {
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement("DELETE FROM events_organized WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting event", e);
        }
    }

    public List<Event> searchEventByName(String name) {
        List<Event> filteredEvents = new ArrayList<>();
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(
                    "SELECT * FROM events_organized WHERE name_event LIKE ?"
            );
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nameEvent = resultSet.getString("name_event");
                String place = resultSet.getString("place");
                LocalDate timeEvent = resultSet.getDate("time_event").toLocalDate();
                String image = resultSet.getString("image");
                Integer scope = resultSet.getInt("scope");
                String descriptionEvent = resultSet.getString("description_event");
                Boolean statusEvent = resultSet.getBoolean("status_event");
                filteredEvents.add(new Event(id, nameEvent, timeEvent, image, place, descriptionEvent, statusEvent, scope));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error searching events", e);
        }
        return filteredEvents;
    }

    public void updateEvent(Event event) {
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(
                    "UPDATE events_organized SET name_event = ?, time_event = ?, image = ?, place = ?, description_event = ?, status_event = ?, scope = ? WHERE id = ?"
            );
            statement.setString(1, event.getEventName());
            statement.setDate(2, java.sql.Date.valueOf(event.getEventStart()));
            statement.setString(3, event.getImgEvent());
            statement.setString(4, event.getLocation());
            statement.setString(5, event.getDescription());
            statement.setBoolean(6, event.getIsStatus());
            statement.setInt(7, event.getTicketToSell());
            statement.setInt(8, event.getIdEvents());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating event", e);
        }
    }

}
