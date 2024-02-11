package com.homefinances.domain.service.customer;

import com.homefinances.domain.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer RegisterCustomer(Customer newCustomer);
    void RemoveCustomer(Integer idCustomer);
    Customer UpdateCustomer(Customer modifyCustomer);
    Customer searchCustomerByName(String name);
    Customer searchCustomerByEmail(String email);
    List<Customer> getListCustomer();
}
