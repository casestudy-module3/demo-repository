package com.example.casestudy.service;

import com.example.casestudy.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();
    List<Customer>findByName(String name);
    boolean delete(int id, Boolean status);
}
