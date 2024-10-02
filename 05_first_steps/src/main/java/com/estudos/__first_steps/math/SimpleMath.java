package com.estudos.__first_steps.math;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return (numberOne) + (numberTwo);
    }

    // método request para SUBTRAÇÃO
    public Double sub(Double numberOne, Double numberTwo) {
        return (numberOne) - (numberTwo);
    }

    // método request para MULTIPLAÇÃO
    public Double multi(Double numberOne,  Double numberTwo) {
        return (numberTwo) * (numberOne);
    }

    // método request para DIVISÃO
    public Double split(Double numberOne,Double numberTwo) {
        return (numberOne) / (numberTwo);
    }

    //método request para MÉDIA, como são 2 values ent dividi por 2 
    public Double avg(Double numberOne, Double numberTwo) {
        return (((numberOne) + (numberTwo)) / 2);
    }

    //método para raiz quadrada
    public Double sqrt(Double number) {
        return Math.sqrt(number);
    }
    
}
