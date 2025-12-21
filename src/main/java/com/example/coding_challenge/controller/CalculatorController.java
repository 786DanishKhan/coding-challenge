package com.example.coding_challenge.controller;

import com.example.coding_challenge.dto.CalculatorDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {


    @PostMapping("/add")
    public int add(@RequestBody CalculatorDto calculatorDto) {
        return calculatorDto.getA() + calculatorDto.getB();
    }

    @PostMapping("/multiply")
    public int multiply(@RequestBody CalculatorDto calculatorDto) {
        return calculatorDto.getA() * calculatorDto.getB();
    }
}
