package com;

public class MyMultiplication {

    public String multiply(String firstFactor, String secondFactor) throws Exception {
        Validator.validate(firstFactor);
        Validator.validate(secondFactor);

        if (firstFactor.length() > secondFactor.length()) {
            String temp = firstFactor;
            firstFactor = secondFactor;
            secondFactor = temp;
        }

        StringBuilder[] intermediateNumbers = new StringBuilder[firstFactor.length()];

        int firstNumberLastIndex = firstFactor.length() - 1;
        int count = 0;

        for (int i = firstNumberLastIndex; i >= 0; i--) {
            int digitOfFirstFactor = Character.digit(firstFactor.charAt(i), 10);

            StringBuilder intermediateNumber = multiplyNumberByOneDigit(secondFactor, digitOfFirstFactor);

            for (int k = 0; k < firstNumberLastIndex - i; k++) {
                intermediateNumber.append("0");
            }

            intermediateNumbers[count++] = intermediateNumber;
        }

        StringBuilder result = intermediateNumbers[0];

        for (int i = 1; i < intermediateNumbers.length; i++) {
            result = add(result, intermediateNumbers[i]);
        }

        return new String(result);
    }

    private StringBuilder multiplyNumberByOneDigit(String number, int digit) {
        int inMemory = 0;
        int secondNumberLastIndex = number.length() - 1;

        StringBuilder intermediateNumber = new StringBuilder();

        for (int j = secondNumberLastIndex; j >= 0; j--) {
            int digitOfSecondFactor = Character.digit(number.charAt(j), 10);

            String product = Integer.toString(digit * digitOfSecondFactor + inMemory);
            inMemory = product.length() > 1 ? Character.digit(product.charAt(0), 10) : 0;

            int lastIndexOfProduct = product.length() - 1;
            String insertedValue = product.length() > 1 ? Character.toString(product.charAt(lastIndexOfProduct)) : product;

            intermediateNumber.insert(0, insertedValue);
        }

        if (inMemory != 0) {
            intermediateNumber.insert(0, inMemory);
        }

        return intermediateNumber;
    }

    private StringBuilder add(StringBuilder firstNumber, StringBuilder secondNumber) {
        int biggerLength = firstNumber.length() > secondNumber.length() ? firstNumber.length() : secondNumber.length();

        for (int i = 0; i < biggerLength - firstNumber.length(); i++) {
            firstNumber.insert(0, "0");
        }

        for (int i = 0; i < biggerLength - secondNumber.length(); i++) {
            secondNumber.insert(0, "0");
        }

        int inMemory = 0;
        StringBuilder result = new StringBuilder();

        for (int i = firstNumber.length() - 1, j = secondNumber.length() - 1; i >= 0 && j >= 0; i--, j--) {
            int digitOfFirstNumber = Character.digit(firstNumber.charAt(i), 10);
            int digitOfSecondNumber = Character.digit(secondNumber.charAt(j), 10);

            String sum = Integer.toString(digitOfFirstNumber + digitOfSecondNumber + inMemory);

            inMemory = sum.length() > 1 ? Character.digit(sum.charAt(0), 10) : 0;

            int lastIndexOfSum = sum.length() - 1;
            result.insert(0, sum.length() > 1 ? Character.digit(sum.charAt(lastIndexOfSum), 10) : sum);
        }

        if (inMemory != 0) {
            result.insert(0, inMemory);
        }

        return result;
    }
}
