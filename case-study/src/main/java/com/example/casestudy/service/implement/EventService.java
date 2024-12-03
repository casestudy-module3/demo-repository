package com.example.casestudy.service.implement;

import com.example.casestudy.model.Event;
import com.example.casestudy.repo.EventRepo;
import com.example.casestudy.service.IEventService;

import java.util.List;

public class EventService implements IEventService {
    private static final EventRepo eventRepo = new EventRepo();
    public List<Event> getEvents() {
        return eventRepo.getEvents();
    }
    public void addEvent(Event event) {
        eventRepo.addEvent(event);
    }
    @Override
    public void deleteEvent(Integer id) {
        eventRepo.deleteEvent(id);
    }
}
