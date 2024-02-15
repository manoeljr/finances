package com.homefinances.web;


import com.homefinances.domain.service.buy.BuyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/buys")
public class BuyRestController {

    private final BuyService service;

    public BuyRestController(BuyService service) {
        this.service = service;
    }


}
