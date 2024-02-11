package com.homefinances.web;

import com.homefinances.domain.model.Customer;
import com.homefinances.domain.service.customer.CustomerService;
import com.homefinances.web.request.customer.RegisterCustomerDTO;
import com.homefinances.web.response.customer.CreatedCustomerDTO;
import com.homefinances.web.response.customer.ResponseCustomer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerRestController {

    private final CustomerService service;

    public CustomerRestController(CustomerService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ResponseCustomer>> getCustomer() {
        var customers = service.getListCustomer();
        if (customers.isEmpty()) {
            return ResponseEntity.ok().body(new ArrayList<>());
        }
        return ResponseEntity.ok().body(ResponseCustomer.convertCustomerForDto(customers));
    }

    @PostMapping
    public ResponseEntity<CreatedCustomerDTO> registerCustomer(@Valid @RequestBody RegisterCustomerDTO registerCustomerDTO) {
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
