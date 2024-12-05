package com.example.casestudy.repo;

import com.example.casestudy.model.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {
    private static List<Customer> customers = new ArrayList<Customer>();

    static {
        customers.add(new Customer(1, "An", "an@gmail.com", "03312223", "DEL", "Vip", LocalDate.now(), 2));
        customers.add(new Customer(2, "AnC", "aEn@gmail.com", "033233123", "ADD", "Normal", LocalDate.now(), 2));
        customers.add(new Customer(3, "AnƯ", "Êan@gmail.com", "03323123", "ADD", "Vip", LocalDate.now(), 1));
        customers.add(new Customer(4, "AnE", "anƯE@gmail.com", "03322123", "DEL", "Normal", LocalDate.now(), 3));
        customers.add(new Customer(5, "AnE", "aƯEWn@gmail.com", "032323123", "ADD", "Vip", LocalDate.now(), 2));
    }

    public List<Customer> findAll() {
        return customers;
    }
}
