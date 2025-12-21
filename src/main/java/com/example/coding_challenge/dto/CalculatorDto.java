package com.example.coding_challenge.dto;

public class CalculatorDto {
    private int a;
    private int b;

    public CalculatorDto(int a, int b){
        this.a = a;
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public int getA() {
        return a;
    }
}
