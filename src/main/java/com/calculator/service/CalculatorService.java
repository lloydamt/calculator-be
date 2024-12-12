package com.calculator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.calculator.mapper.OperatorMapper;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CalculatorService {

    private final OperatorMapper operatorMapper; 
    
    public Double calculate(double firstNumber, double secondNumber, String operation) {
        return operatorMapper.mapDigits(operation).apply(firstNumber, secondNumber);
    }

    public Double calculate(List<Double> numbers, String operation) {
        return operatorMapper.mapList(operation).apply(numbers);
    }
}