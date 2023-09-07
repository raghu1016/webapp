package com.springboot.webapp.dao;

import com.springboot.webapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    public List<Customer> findAllByOrderByLastNameAsc();
}
