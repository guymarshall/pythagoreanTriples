package com.marshall.guy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int gcd(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        } else {
            return gcd(number2, number1 % number2);
        }
    }

    public static void main(String[] args) {
	    int numberTriplesCalculated = 0;
        int sideA = 1;

        System.out.print("Number of triples to calculate: ");
        Scanner scanner = new Scanner(System.in);
        int numberTriplesNeeded = scanner.nextInt();

        boolean loopA = numberTriplesNeeded > 0;

        int[] result;

        while (loopA) {
            int sideB = 1;
            boolean loopB = true;
            while (sideB <= sideA && loopB) {
                if (Math.round(gcd(sideA, sideB)) == 1) {
                    int sideC = (int)Math.round(Math.hypot(sideA, sideB));

                    if (sideC * sideC == (sideA * sideA + sideB * sideB)) {
                        numberTriplesCalculated++;
                        result = new int[]{sideB, sideA, sideC};
                        System.out.println(numberTriplesCalculated + ": " + Arrays.toString(result));

                        if (numberTriplesCalculated == numberTriplesNeeded) {
                            loopA = false;
                            loopB = false;
                        }
                    }
                }

                sideB++;
            }

            sideA++;
        }

        if (numberTriplesNeeded < 0) {
            System.out.printf("%d is invalid", numberTriplesNeeded);
        }
    }
}