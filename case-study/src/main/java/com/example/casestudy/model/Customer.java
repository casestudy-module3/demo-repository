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
    private String typeTicket;
    private LocalDate date;
    private Integer numberTickets;
    public Customer() {}
    public Customer(Integer id, String name, String email, String phone, Boolean status, LocalDate date, String typeTicket, Integer numberTickets) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.typeTicket = typeTicket;
        this.date = date;
        this.numberTickets = numberTickets;
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
    public String getTypeTicket() {
        return typeTicket;
    }
    public void setTypeTicket(String typeTicket) {
        this.typeTicket = typeTicket;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Integer getNumberTickets() {
        return numberTickets;
    }
    public void setNumberTickets(Integer numberTickets) {
        this.numberTickets = numberTickets;
    }
}
