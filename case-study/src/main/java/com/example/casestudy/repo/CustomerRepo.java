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
            PreparedStatement statement = Database.getConnection().prepareStatement("SELECT c.id, c.name_customer, c.email, c.phone_number, c.status_customer, t.time_book, pt.id_ticket_type, tt.name_ticket, COUNT(t.id) AS tickets_number, eo.name_event FROM customers c JOIN tickets t ON c.id = t.id_customer JOIN price_tickets pt ON t.id_price = pt.id_price_ticket JOIN events_organized eo ON t.id_event = eo.id JOIN ticket_types tt ON pt.id_ticket_type = tt.id \n" +
                    "WHERE t.id_event = eo.id GROUP BY c.id, c.name_customer, c.email, c.phone_number, c.status_customer, t.time_book, pt.id_ticket_type, tt.name_ticket, eo.name_event;");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name_customer");
                String address = resultSet.getString("email");
                String phone = resultSet.getString("phone_number");
                Boolean status = resultSet.getBoolean("status_customer");
                LocalDate timeBook = resultSet.getDate("time_book").toLocalDate();
                String ticketType = resultSet.getString("name_ticket");
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
            String sql = "SELECT c.id, c.name_customer, c.email,c.phone_number, c.status_customer,t.time_book,pt.id_ticket_type,tt.name_ticket,COUNT(t.id) AS tickets_number, eo.name_event FROM customers c JOIN tickets t ON c.id = t.id_customer JOIN price_tickets pt ON t.id_price = pt.id_price_ticket JOIN events_organized eo ON t.id_event = eo.id JOIN ticket_types tt ON pt.id_ticket_type = tt.id WHERE c.name_customer like ? GROUP BY c.id,c.name_customer, c.email,c.phone_number, c.status_customer, t.time_book, pt.id_ticket_type, tt.name_ticket, eo.name_event;";
            PreparedStatement statement = Database.getConnection().prepareStatement(sql);
            statement.setString(1, "%"+name +"%" );
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String nameCustomer = resultSet.getString("name_customer");
                String address = resultSet.getString("email");
                String phone = resultSet.getString("phone_number");
                Boolean status = resultSet.getBoolean("status_customer");
                LocalDate timeBook = resultSet.getDate("time_book").toLocalDate();
                String ticketType = resultSet.getString("name_ticket");
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
