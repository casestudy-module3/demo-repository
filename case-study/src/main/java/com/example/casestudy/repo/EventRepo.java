package com.example.casestudy.repo;

import com.example.casestudy.model.Event;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventRepo {
    private static List<Event> events=new ArrayList<>();
    static {
        events.add(new Event(1, "Concert ATSH", LocalDate.of(2024, 12, 1), "img/insta.png", "Đà Nẵng", "Music concert in Da Nang", true, 500));
        events.add(new Event(2, "Art Exhibition", LocalDate.of(2024, 12, 5), "img/insta.png", "Hà Nội", "Art gallery showcasing local artists", false, 200));
        events.add(new Event(3, "Tech Meetup", LocalDate.of(2024, 12, 10), "img/insta.png", "Hồ Chí Minh", "A meetup for tech enthusiasts", true, 150));
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        event.setIdEvents(events.size() + 1);
        events.add(event);
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
