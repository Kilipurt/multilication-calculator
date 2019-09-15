package com;

public class Main {

    public static void main(String[] args) {
        if (args[0].equals("alg1")) {
            MyMultiplication myMultiplication = new MyMultiplication();

            try {
                System.out.println(myMultiplication.multiply(args[1], args[2]));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if (args[0].equals("alg2")) {
            BigIntegerMultiplication bigIntegerMultiplication = new BigIntegerMultiplication();

            try {
                System.out.println(bigIntegerMultiplication.multiply(args[1], args[2]));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
