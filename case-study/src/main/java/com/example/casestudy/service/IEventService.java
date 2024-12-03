package com.example.casestudy.service;

import java.util.List;

public interface IEventService<T> {
    List<T> getEvents();
}
