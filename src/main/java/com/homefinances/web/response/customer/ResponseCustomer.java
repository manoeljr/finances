package com.homefinances.web.response.customer;


import com.homefinances.domain.model.Customer;
import com.homefinances.domain.model.Purchase;

import java.util.List;
import java.util.stream.Collectors;


public record ResponseCustomer(
        String name,
        String username,
        String email,
        List<Purchase> purchases
) {
    public static List<ResponseCustomer> convertCustomerForDto(List<Customer> customers) {
        return customers.stream().map( customer -> {
            return new ResponseCustomer(customer.getName(), customer.getUsername(), customer.getEmail(), customer.getPurchases());
        }).collect(Collectors.toList());
    }
}
