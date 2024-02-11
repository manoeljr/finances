package com.homefinances.domain.service.customer;

import com.homefinances.domain.model.Customer;
import com.homefinances.domain.repository.CustomerDAO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerDAO repository;
    private final PasswordEncoder passwordEncoder;

    public CustomerServiceImpl(CustomerDAO repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Customer RegisterCustomer(Customer newCustomer) {
        newCustomer.setPassword(passwordEncoder.encode(newCustomer.getPassword()));
        return repository.save(newCustomer);
    }

    @Override
    public void RemoveCustomer(Integer idCustomer) {

    }

    @Override
    public Customer UpdateCustomer(Customer modifyCustomer) {
        var customer = repository.getReferenceById(modifyCustomer.getIdCustomer());
        customer.setName(modifyCustomer.getName());
        customer.setEmail(modifyCustomer.getEmail());
        customer.setRoles(modifyCustomer.getRoles());
        return repository.save(customer);
    }

    @Override
    public Customer searchCustomerByName(String name) {
        return repository.findCustomerByName(name);
    }

    @Override
    public Customer searchCustomerByEmail(String email) {
        return repository.findCustomerByEmail(email);
    }

    @Override
    public List<Customer> getListCustomer() {
        return repository.findAll();
    }
}
