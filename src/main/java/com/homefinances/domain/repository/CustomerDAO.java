package com.homefinances.domain.repository;

import com.homefinances.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerDAO extends JpaRepository<Customer, Integer> {
    Customer findCustomerByName(String name);
    Customer findCustomerByEmail(String email);
}
