package com.example.casestudy.service.implement;

import com.example.casestudy.model.Customer;
import com.example.casestudy.repo.CustomerRepo;
import com.example.casestudy.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private static CustomerRepo customerRepo = new CustomerRepo();

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }
}
