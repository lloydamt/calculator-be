package com.calculator.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class CalcRequestBody {
    private Double firstNumber;
    private Double secondNumber;
    private String operation;
}
