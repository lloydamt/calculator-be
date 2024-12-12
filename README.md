# calculator-be

This repository contains a simple calculator REST API built using Spring Boot. The calculator performs basic arithmetic operations such as addition, subtraction, multiplication, and division.

## Assumptions

1. **Basic Arithmetic Operations**: The app is designed to handle basic operations: addition, subtraction, multiplication, and division.
2. **Input Validation**: User input is assumed to be valid numbers. However, the API returns a 400 response if invalid characters like letters or special characters are passed as inputs.
3. **Division by Zero**: Division by zero is handled gracefully by throwing a 400 error to the user.

## Limitations

1. **Complex Calculations**: The app does not support advanced mathematical operations like exponents, logarithms, or trigonometric functions.
2. **Error Handling**: Limited error handling for edge cases, such as very large numbers or invalid input types.
3. **Data-type Inaccuracties** The API performs its operations using the Double data type, so slight inaccuracies might occur in results due to the limited accuracy of the data type.

## Prerequisites

To run this application, ensure you have the following installed on your system:

- [JDK 1.8](https://www.oracle.com/java/technologies/downloads/#java8)
- [Maven 3](https://maven.apache.org/)

## Steps to Run the Application

1. **Clone the Repository**:

```
https://github.com/lloydamt/calculator-be.git
```

2. **Change Directory**:

```
cd calculator-be
```

3. **Run the API locally**

```
mvn spring-boot:run
```

Alternatively, execute the main method of the `CalculatorApplication` class file.

### Similar Frontend app can be located at

```
https://github.com/lloydamt/calculator-fe
```
