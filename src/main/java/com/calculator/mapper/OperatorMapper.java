package com.calculator.mapper;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import org.springframework.stereotype.Component;

@Component
public class OperatorMapper {
    private final Map<String, BiFunction<Double, Double, Double>> digitMap = Map.of(
        "+", (firstNum, secondNum) -> firstNum + secondNum,
        "-", (firstNum, secondNum) -> firstNum - secondNum,
        "*", (firstNum, secondNum) -> firstNum * secondNum,
        "/", (firstNum, secondNum) -> firstNum / secondNum
    );

    private final Map<String, Function<List<Double>, Double>> listMap = Map.of(
        "+", numbers -> numbers.stream().reduce(0.0, Double::sum),
        "-", numbers -> numbers.stream().reduce(numbers.get(0), (subTotal, element) -> subTotal - element),
        "*", numbers -> numbers.stream().reduce(numbers.get(0), (finalMul, element) -> finalMul * element),
        "/", numbers -> numbers.stream().reduce(numbers.get(0), (finalQuotient, element) -> finalQuotient / element)
    );

    public BiFunction<Double, Double, Double> mapDigits(String operator) {
        return digitMap.get(operator);
    }

    public Function<List<Double>, Double> mapList(String operator) {
        return listMap.get(operator);
    }
}
