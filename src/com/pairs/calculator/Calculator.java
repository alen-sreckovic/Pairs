/*
 * Pairs! - v0.1
 * Author: Alen Sreckovic
 * Date: August 4, 2020
 * JRE System Library: Java SE 14.0.1+7
 * */

package com.pairs.calculator;
public class Calculator {

    public Calculator(){

    }

    //This method handles the functional-requirement pertinent to finding all multiples of a number.
    public void multiplesCalc(int num){
        for(int i = num; i >= 1; i--) {
              for(int j = 1; j <= i; j++ ) {
                if(i * j == num) {
                  System.out.println(j + " * " + i + " = " + num);
                }
            }
        }
    }

/*
 * This method handles the functional-requirement pertinent to finding factors of two numbers. The starting
 * and ending flags are set using user-inputted number-pairs. Negative numbers are turned into positive
 * numbers such that the larger number's positive value is the ending point and the largest number's
 * negative value is the starting point, hence the instances of multiplication with -1.
 * */
    public void factorsCalc(int xVar, int constVar){
        int start = 0;
        int end = 0;

        if(xVar > 0 && constVar > 0){
            if(isLarger(xVar, constVar)){
                int newStart = xVar * (-1);
                start = newStart;
                end = xVar;
            } else {
                int newStart = constVar * (-1);
                start = newStart;
                end = constVar;
            }
        }

        if(xVar < 0){
            int tempXvar = xVar * (-1);
            if(isLarger(tempXvar, constVar)){
                start = xVar;
                end = tempXvar;
            }
        } else if(constVar < 0){
            int tempConstVar = constVar * (-1);
            if(isLarger(tempConstVar, constVar)){
                start = constVar;
                end = tempConstVar;
            }
        }

        int counter = 0;
        for(int i = start; i <= end; i++) {
            for (int j = start; j <= end; j++) {
                if (i * j == constVar && i + j == xVar) {
                    System.out.println("Candidate numbers: " + i + " & " + j);
                    counter++;
                }
                if(i == j){
                    break;
                }
            }
        }
        if(counter == 0){
            System.out.println("No candidate numbers found.");
        }
    }

    //A helper method that returns a boolean value pertaining to two numbers and whether the first number is larger.
    private boolean isLarger(int num1, int num2){
        return num1 > num2;
    }
}
