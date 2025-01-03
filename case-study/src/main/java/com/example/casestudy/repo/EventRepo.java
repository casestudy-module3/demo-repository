package com.example.casestudy.repo;

import com.example.casestudy.model.Event;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventRepo {
    private static List<Event> events=new ArrayList<>();
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
                events.add(new Event(id,nameEvent,timeEvent,image,place,descriptionEvent,statusEvent,scope));
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
        String query="DELETE FROM event_tickets_sale WHERE id_event = ?";
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting event", e);
        }
        String query3="DELETE FROM tickets WHERE id_event = ?";
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query3);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting event", e);
        }
        String query2="DELETE FROM events_organized WHERE id = ?";
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement(query2);
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
    public void updateEvent(int id, Event event) {
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement("update events_organized set name_event =?, place=?, time_event=?, image=?, scope=?, description_event=? where id=?");
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getLocation());
            statement.setString(3, String.valueOf(event.getEventStart()));
            statement.setString(4, event.getImgEvent());
            statement.setInt(5, event.getTicketToSell());
            statement.setString(6, event.getDescription());
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error");
        }
    }

}
