package com.homefinances.web;


import com.homefinances.domain.service.purchase.PurchaseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/purchases")
public class PurchaseRestController {

    private final PurchaseService service;

    public PurchaseRestController(PurchaseService service) {
        this.service = service;
    }


}
