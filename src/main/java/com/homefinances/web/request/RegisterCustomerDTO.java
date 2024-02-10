package com.homefinances.web.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.homefinances.domain.model.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record RegisterCustomerDTO(
        @Valid @NotBlank String name,
        @Valid @NotBlank String username,
        @Valid @NotBlank String password,
        @JsonIgnoreProperties("email") @Email String email
) {
    public Customer fromDtoForEntity() {
        var customer = new Customer();
        customer.setName(name());
        customer.setPassword(password());
        customer.setUsername(username());
        customer.setEmail(email());

        return customer;
    }
}
