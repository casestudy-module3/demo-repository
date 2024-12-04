package com.example.casestudy.model;

public class Statistic {
    private int totalEvents;
    private int totalTicketsSold;
    private int totalActiveEvents;
    public Statistic(int totalEvents, int totalTicketsSold, int totalActiveEvents) {
        this.totalEvents = totalEvents;
        this.totalTicketsSold = totalTicketsSold;
        this.totalActiveEvents = totalActiveEvents;
    }
    public int getTotalEvents() {
        return totalEvents;
    }
    public void setTotalEvents(int totalEvents) {
        this.totalEvents = totalEvents;
    }
    public int getTotalTicketsSold() {
        return totalTicketsSold;
    }
    public void setTotalTicketsSold(int totalTicketsSold) {
        this.totalTicketsSold = totalTicketsSold;
    }
    public int getTotalActiveEvents() {
        return totalActiveEvents;
    }
    public void setTotalActiveEvents(int totalActiveEvents) {
        this.totalActiveEvents = totalActiveEvents;
    }
}
