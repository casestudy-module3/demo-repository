package com.example.casestudy.repo;

import com.example.casestudy.model.Event;

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
}
