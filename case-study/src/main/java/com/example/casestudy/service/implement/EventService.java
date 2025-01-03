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
    public List<Event> searchEventByName(String name) {
        return eventRepo.searchEventByName(name);
    }

    @Override
    public boolean updateEvent(int id, Event event) {
         eventRepo.updateEvent(id, event);
         return true;
    }
}
