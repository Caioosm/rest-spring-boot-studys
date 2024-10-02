package com.estudos.__first_steps.controllers;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import com.estudos.__first_steps.converters.NumberConverter;
import com.estudos.__first_steps.exceptions.UnsupportedMathOperationException;
import com.estudos.__first_steps.math.SimpleMath;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MathController {

    // private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();

    // método request para SOMA
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    // método request para SUBTRAÇÃO
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {

        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    // método request para MULTIPLAÇÃO
    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multi(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {

        if (!NumberConverter.isNumeric(numberTwo) || !NumberConverter.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return math.multi(NumberConverter.convertToDouble(numberTwo), NumberConverter.convertToDouble(numberOne));
    }

    // método request para DIVISÃO
    @RequestMapping(value = "/split/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double split(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberTwo) || !NumberConverter.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return math.split(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    //método request para MÉDIA, como são 2 values ent dividi por 2 
    @RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double avg(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {
        if (!NumberConverter.isNumeric(numberTwo) || !NumberConverter.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return math.avg(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    //método request para RAIZ QUADRADA
    @RequestMapping(value = "/sqrt/{number}", method=RequestMethod.GET)
    public Double sqrt(@PathVariable(value = "number") String number) {
        if (!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return math.sqrt(NumberConverter.convertToDouble(number));
    }
    
}
