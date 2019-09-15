package com;

public class Validator {

    public static void validate(String number) throws Exception {
        if (number == null || number.isEmpty()) {
            throw new Exception("Number is empty");
        }

        for (Character ch : number.toCharArray()) {
            if (!Character.isDigit(ch)) {
                throw new Exception("Wrong enter number: " + number);
            }
        }
    }
}