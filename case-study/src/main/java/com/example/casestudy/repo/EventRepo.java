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
        event.setIdEvents(events.size() + 1);
        events.add(event);
    }
    public void deleteEvent(Integer id) {
        events.removeIf(event -> event.getIdEvents().equals(id));
    }
    public List<Event>searchEventByName(String name){
        List<Event> filteredEvents = new ArrayList<>();
        for (Event event : events) {
            if (event.getEventName().toLowerCase().contains(name.toLowerCase())) {
                filteredEvents.add(event);
            }
        }
        return filteredEvents;
    }
    public Event getEventById(Integer id) {
        for (Event event : events) {
            if (event.getIdEvents().equals(id)) {
                return event;
            }
        }
        return null;
    }
    public void updateEvent(int id, Event event){
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement("update events_organized set name =?, place=?, time_event=?, image=?, scope=?, description_event=? where id=?");
            statement.setString(1, event.getEventName());
            statement.setString(2, event.getLocation());
            statement.setString(3, String.valueOf(event.getEventStart()));
            statement.setString(4, event.getImgEvent());
            statement.setInt(5, event.getTicketToSell());
            statement.setString(6, event.getDescription());
            statement.setInt(7, id);

        } catch (SQLException e) {
            System.out.println("Error");
        }
    }
}
