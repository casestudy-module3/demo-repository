package com.example.casestudy.service.implement;

import com.example.casestudy.model.Event;
import com.example.casestudy.repo.EventRepo;
import com.example.casestudy.service.IEventService;

import java.util.ArrayList;
import java.util.List;

public class EventService implements IEventService {
    private static final EventRepo eventRepo = new EventRepo();
    List<Event> events = new ArrayList<>();
    public List<Event> getEvents() {
        return eventRepo.getEvents();
    }
    @Override
    public Event findById(int id) {
        events =eventRepo.getEvents();
        for(int i = 0; i<events.size(); i++){
            if(events.get(i).getIdEvents() == id){
                return events.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean updateEvent(int id, Event event) {
        if(findById(id) != null){
            eventRepo.upDate(event);
            return true;
        }
        return false;
    }
}
