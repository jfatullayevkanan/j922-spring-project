package com.example.j922springproject.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorService {

    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorService();
        System.out.println(calculatorService.findMax(5, 6));
    }

    public int findMax(int a, int b) {
        log.info("ActionLog.sum.start");
        return a > b ? a : b;
    }
}
