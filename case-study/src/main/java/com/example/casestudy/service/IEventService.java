package com.example.casestudy.service;

import com.example.casestudy.model.Event;

import java.util.List;

public interface IEventService<T> {
    List<T> getEvents();
    void addEvent(Event event);
    void deleteEvent(Integer id);
    List<T>searchEventByName(String name);
    void updateEvent(Event event);
}
