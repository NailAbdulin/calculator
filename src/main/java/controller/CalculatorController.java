package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.CalculatorService;

@RestController
public class CalculatorController {
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @GetMapping
    public String welcome() {
        return "Добро пожадовать!";
    }

    private final CalculatorService calculatorService;

    @GetMapping("/calculator/plus")
    public String plus(@RequestParam(name = "num1",required = false) Integer a, @RequestParam(name = "num2",required = false) Integer b ) {
        if(a == null || b == null) return "одно поле пустое";
        int plus = calculatorService.plus(a, b);
        return a + " + " + b + " = " + plus;
    }
    @GetMapping("/calculator/minus")
    public String minus(@RequestParam(name = "num1",required = false) Integer a,@RequestParam(name = "num2",required = false) Integer b ) {
        if(a == null || b == null) return "одно поле пустое";
        int minus = calculatorService.minus(a, b);
        return a + " - " + b + " = " + minus;
    }
    @GetMapping("/calculator/multiply")
    public String multiply(@RequestParam(name = "num1",required = false) Integer a,@RequestParam(name = "num2",required = false) Integer b ) {
        if(a == null || b == null) return "одно поле пустое";
        int multiply = calculatorService.multiply(a, b);
        return a + " * " + b + " = " + multiply;
    }@GetMapping("/calculator/divide")
    public String divide(@RequestParam(name = "num1", required = false) Integer a,@RequestParam(name = "num2",required = false) Integer b ) {
        if(a == null || b == null) return "одно поле пустое";
        double divide = calculatorService.divide(a, b);
        return a + " / " + b + " = " + divide;
    }
}

