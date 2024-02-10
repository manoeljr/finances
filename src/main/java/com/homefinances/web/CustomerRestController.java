package com.homefinances.web;

import com.homefinances.domain.service.customer.CustomerService;
import com.homefinances.web.request.RegisterCustomerDTO;
import com.homefinances.web.response.CreatedCustomer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerRestController {

    private final CustomerService service;

    public CustomerRestController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreatedCustomer> registerCustomer(@Valid @RequestBody RegisterCustomerDTO registerCustomerDTO) {
        var result = service.RegisterCustomer(registerCustomerDTO.fromDtoForEntity());
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(result.getIdCustomer())
                .toUri();
        if (result != null) {
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.badRequest().build();
    }
}
