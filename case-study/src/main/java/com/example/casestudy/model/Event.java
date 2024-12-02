package com.example.casestudy.model;

import java.time.LocalDate;

public class Event {
    private Integer idEvents;
    private String eventName;
    private LocalDate eventStart;
    private String imgEvent;
    private String location;
    private String description;
    private Boolean isStatus;
    private Integer TicketToSell;

    public Event(){

    }
    public Event(String eventName, LocalDate eventStart, String imgEvent, String location, String description, Boolean isStatus, Integer TicketToSell) {
        this.eventName = eventName;
        this.eventStart = eventStart;
        this.imgEvent = imgEvent;
        this.location = location;
        this.description = description;
        this.isStatus = isStatus;
        this.TicketToSell = TicketToSell;
    }
    public Event(Integer idEvents,String eventName, LocalDate eventStart, String imgEvent, String location, String description, Boolean isStatus, Integer TicketToSell) {
        this.idEvents = idEvents;
        this.eventName = eventName;
        this.eventStart = eventStart;
        this.imgEvent = imgEvent;
        this.location = location;
        this.description = description;
        this.isStatus = isStatus;
        this.TicketToSell = TicketToSell;
    }
    public Integer getIdEvents() {
        return idEvents;
    }
    public void setIdEvents(Integer idEvents) {
        this.idEvents = idEvents;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public LocalDate getEventStart() {
        return eventStart;
    }
    public void setEventStart(LocalDate eventStart) {
        this.eventStart = eventStart;
    }
    public String getImgEvent() {
        return imgEvent;
    }
    public void setImgEvent(String imgEvent) {
        this.imgEvent = imgEvent;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getIsStatus() {
        return isStatus;
    }
    public void setIsStatus(Boolean isStatus) {
        this.isStatus = isStatus;
    }
    public Integer getTicketToSell() {
        return TicketToSell;
    }
    public void setTicketToSell(Integer TicketToSell) {
        this.TicketToSell = TicketToSell;
    }
}
