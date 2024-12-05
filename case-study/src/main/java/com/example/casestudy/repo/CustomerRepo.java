package com.example.casestudy.repo;

import com.example.casestudy.model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private static List<Customer> customers = new ArrayList<Customer>();
    public List<Customer> getCustomers() {
        customers.clear();
        try {
            PreparedStatement statement = Database.getConnection().prepareStatement("select c.id, c.name_customer, c.email, c.phone_number, c.status_customer, t.time_book, pt.id_ticket_type, count(t.id) as tickets_number, eo.name_event from customers c join tickets t on c.id = t.id_customer join price_tickets pt on t.id_price = pt.id_price_ticket join events_organized eo on t.id_event = eo.id where t.id_event = eo.id group by c.id, c.name_customer, c.email, c.phone_number, c.status_customer, t.time_book, pt.id_ticket_type, eo.name_event;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name_customer");
                String address = resultSet.getString("email");
                String phone = resultSet.getString("phone_number");
                Boolean status = resultSet.getBoolean("status_customer");
                LocalDate timeBook = resultSet.getDate("time_book").toLocalDate();
                String ticketType = resultSet.getString("id_ticket_type");
                Integer ticketsNumber = resultSet.getInt("tickets_number");
                String eventName = resultSet.getString("name_event");
                customers.add(new Customer(id, name, address, phone, status, timeBook, ticketType, ticketsNumber, eventName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    public List<Customer> searchCustomerByName( String name) {
        customers.clear();
        try{
            PreparedStatement statement = Database.getConnection().prepareStatement("select c.id, c.name_customer, c.email, c.phone_number, c.status_customer, t.time_book, pt.id_ticket_type, count(t.id) as tickets_number eo.name_event from customers c join tickets t on c.id = t.id_customer join price_tickets pt on t.id_price = pt.id_price_ticket join events_organized eo on t.id_event = eo.id where c.name_customer like ? group by c.id, c.name_customer, c.email, c.phone_number, c.status_customer, t.time_book, pt.id_ticket_type  eo.name_event;");
            statement.setString(2,"%"+name+"%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String nameCustomer = resultSet.getString("name_customer");
                String address = resultSet.getString("email");
                String phone = resultSet.getString("phone_number");
                Boolean status = resultSet.getBoolean("status_customer");
                LocalDate timeBook = resultSet.getDate("time_book").toLocalDate();
                String ticketType = resultSet.getString("id_ticket_type");
                Integer ticketsNumber = resultSet.getInt("tickets_number");
                String eventName = resultSet.getString("name_event");
                customers.add(new Customer(id, nameCustomer, address, phone, status, timeBook, ticketType, ticketsNumber, eventName));
            }
        } catch (SQLException e) {
            System.out.println("Error");
        }
        return customers;
    }
}
