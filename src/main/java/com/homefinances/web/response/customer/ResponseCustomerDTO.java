package com.homefinances.web.response.customer;


import com.homefinances.domain.model.Customer;
import com.homefinances.domain.model.Buy;

import java.util.List;
import java.util.stream.Collectors;


public record ResponseCustomerDTO(
        String name,
        String username,
        String email,
        List<Buy> purchases
) {
    public static List<ResponseCustomerDTO> convertCustomerForDto(List<Customer> customers) {
        return customers.stream().map(
                customer -> new ResponseCustomerDTO(
                        customer.getName(),
                        customer.getUsername(),
                        customer.getEmail(),
                        customer.getBuys()
                )).collect(Collectors.toList());
    }

}
