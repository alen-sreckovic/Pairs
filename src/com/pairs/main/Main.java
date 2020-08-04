/*
 * Pairs! - v0.1
 * Author: Alen Sreckovic
 * Date: August 4, 2020
 * JRE System Library: Java SE 14.0.1+7
 * */

package com.pairs.main;

import com.pairs.calculator.Calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * The main method handles the menu component of the application. User options are handled by a switch-case.
 * Sanitization of user-input is handled by try-catch blocks. Scanner.nextLine() function-calls are placed where
 * they are to clear the input buffer - without the Scanner.nextLine() function-calls, if a user inputs
 * an incorrect value, the next iteration of the while-loop will throw an Exception as the user's input will
 * no longer be stored in .charAt{0}; the app will attempt to instead store user-input in .charAt{1} or higher.
 * */
public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Pairs! - by, Alen Sreckovic");

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        Calculator calc = new Calculator();


        while(true) {
            System.out.println("\nPlease press:\n[a] To find multiples of a number\n[b] For help with " +
                    "factorisation\n[x] To exit");
                char userInput = scanner.nextLine().charAt(0);
                switch(userInput){
                    case 'a':
                        System.out.print("Please enter a whole number to find it's multiples: ");
                        try {
                            int userNum = scanner.nextInt();
                            calc.multiplesCalc(userNum);
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("\nInvalid input...please try again\n");
                            scanner.nextLine();
                            break;
                        }
                    case 'b':
                        System.out.print("Please enter the value of the x-variable.\nIf the coefficient is" +
                                " a negative value, include the subtraction operator: ");
                        try {
                            int xVar = scanner.nextInt();
                            System.out.println("Please enter the value of the constant.\nIf the constant is a" +
                                    " negative value, include the subtraciton operator: ");
                            int constVar = scanner.nextInt();
                            calc.factorsCalc(xVar, constVar);
                            scanner.nextLine();
                            break;
                        } catch (InputMismatchException e){
                            System.out.println("\nInvalid input...please try again\n");
                            scanner.nextLine();
                            break;
                        }
                    case 'x':
                        System.out.println("Thank you for using Pairs! Goodbye.");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid input...Try again.");
            }
        }
    }
}

