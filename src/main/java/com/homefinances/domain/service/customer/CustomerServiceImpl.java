package com.homefinances.domain.service.customer;

import com.homefinances.domain.model.Customer;
import com.homefinances.domain.repository.CustomerDAO;
import com.homefinances.enums.TypeRoles;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
        newCustomer.setEnabled(true);
        newCustomer.setRoles(TypeRoles.USER);
        newCustomer.setPassword(passwordEncoder.encode(newCustomer.getPassword()));
        return repository.save(newCustomer);
    }

    @Override
    public void RemoveCustomer(Integer idCustomer) {

    }

    @Override
    public Customer UpdateCustomer(Customer modifyCustomer) {
        return null;
    }

    @Override
    public Customer searchCustomerByName(String name) {
        return null;
    }

    @Override
    public Customer searchCustomerByEmail(String email) {
        return null;
    }
}
