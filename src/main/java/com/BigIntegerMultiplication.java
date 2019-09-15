package com;

import java.math.BigInteger;

public class BigIntegerMultiplication {

    public String multiply(String firstFactor, String secondFactor) throws Exception {
        Validator.validate(firstFactor);
        Validator.validate(secondFactor);

        BigInteger firstNumber = new BigInteger(firstFactor);
        BigInteger secondNumber = new BigInteger(secondFactor);

        return firstNumber.multiply(secondNumber).toString();
    }
}