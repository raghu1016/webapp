package com.springboot.webapp.service;

import com.springboot.webapp.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void deleteById(int id);
}
