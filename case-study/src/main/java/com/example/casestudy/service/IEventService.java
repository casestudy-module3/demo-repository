package com.example.casestudy.service;

import com.example.casestudy.model.Event;

import java.util.List;

public interface IEventService<T> {
    List<T> getEvents();
    Event findById(int id);
    boolean updateEvent(int id, Event event);
}
