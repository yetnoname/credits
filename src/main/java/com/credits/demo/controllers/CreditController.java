package com.credits.demo.controllers;

import com.credits.demo.dto.CreditRequestDto;
import com.credits.demo.entities.Credit;
import com.credits.demo.services.CreditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/credits")
public class CreditController {

    private CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping
    public Credit create(@RequestBody CreditRequestDto dto) {
        return creditService.create(dto);
    }

    @GetMapping("/all")
    public List<Credit> getAll() {
        return creditService.getAll();
    }

    @GetMapping("/user/{id}")
    public List<Credit> getByUserId(@PathVariable("id") Long userId) {
        return creditService.getByUserId(userId);
    }

}
