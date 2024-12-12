package com.calculator.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.Model.CalcListRequestBody;
import com.calculator.Model.CalcRequestBody;
import com.calculator.service.CalculatorService;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/calculate")
@AllArgsConstructor
public class CalculatorController {

    final List<String> validOperations = List.of("+", "-", "*", "/");

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping
    public ResponseEntity<Double> calculate(@RequestBody CalcRequestBody body) {
        if (!validOperations.contains(body.getOperation())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if ("/".equals(body.getOperation()) && body.getSecondNumber() == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Double>
        (calculatorService.calculate(body.getFirstNumber(), body.getSecondNumber(), body.getOperation()), HttpStatus.OK);
    }

    @PostMapping("/bulk")
    public ResponseEntity<Double> calculateBulk(@RequestBody CalcListRequestBody body) {
        if (!validOperations.contains(body.getOperation())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if ("/".equals(body.getOperation()) && body.getNumbers().indexOf(0.0) > 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Double>(
            calculatorService.calculate(body.getNumbers(), body.getOperation()),
            HttpStatus.OK
        );
    }
}
