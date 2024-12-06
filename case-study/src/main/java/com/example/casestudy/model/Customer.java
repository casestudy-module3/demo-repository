package com.example.casestudy.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer {
    private Integer id;
    private String name;
    private String email;
    private String phone;
    private Boolean status;
    private LocalDate timeBook;
    private String ticketType;
    private Integer ticketsNumber;
    private String eventName;
    public Customer() {}
    public Customer(Integer id, String name, String email, String phone, Boolean status, LocalDate timeBook, String ticketType, Integer ticketsNumber, String eventName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.timeBook = timeBook;
        this.ticketType = ticketType;
        this.ticketsNumber = ticketsNumber;
        this.eventName = eventName;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public LocalDate getTimeBook() {
        return timeBook;
    }
    public void setTimeBook(LocalDate timeBook) {
        this.timeBook = timeBook;
    }
    public Integer getTicketsNumber() {
        return ticketsNumber;
    }
    public void setTicketsNumber(Integer numberTickets) {
        this.ticketsNumber = numberTickets;
    }
    public String getEventName(){
        return eventName;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTicketType() {
        return ticketType;
    }

}
