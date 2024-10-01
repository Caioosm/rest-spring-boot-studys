package com.estudos.__first_steps.controllers;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import com.estudos.__first_steps.exceptions.UnsupportedMathOperationException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MathController {

    // private final AtomicLong counter = new AtomicLong();

    // método request para SOMA
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    // método request para SUBTRAÇÃO
    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    // método request para MULTIPLAÇÃO
    @RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multi(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberTwo) || !isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return convertToDouble(numberTwo) * convertToDouble(numberOne);
    }

    // método request para DIVISÃO
    @RequestMapping(value = "/split/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double split(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberTwo) || !isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    //método request para MÉDIA, como são 2 values ent dividi por 2 
    @RequestMapping(value = "/avg/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double avg(@PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberTwo) || !isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return ((convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2);
    }

    //método request para RAIZ QUADRADA
    @RequestMapping(value = "/sqrt/{number}", method=RequestMethod.GET)
    public Double sqrt(@PathVariable(value = "number") String number) {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please, set a numeric value");
        }

        return Math.sqrt(convertToDouble(number));
    }
    

    private Double convertToDouble(String strNumber) {
        if (strNumber == null)
            return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number))
            return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null)
            return false;
        String number = strNumber.replaceAll(",", ".");

        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
