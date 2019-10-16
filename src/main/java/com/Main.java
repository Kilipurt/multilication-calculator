package com;

public class Main {

    public static void main(String[] args) {
        switch (args[0]) {
            case "alg1":
                MyMultiplication myMultiplication = new MyMultiplication();

                try {
                    System.out.println(myMultiplication.multiply(args[1], args[2]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            case "alg2":
                BigIntegerMultiplication bigIntegerMultiplication = new BigIntegerMultiplication();

                try {
                    System.out.println(bigIntegerMultiplication.multiply(args[1], args[2]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                break;
            default:
                System.out.println("Algorithm " + args[0] + " does not exist");
                break;
        }
    }
}
