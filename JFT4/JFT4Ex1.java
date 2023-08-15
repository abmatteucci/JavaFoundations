package JFT4;
/*
    Write a Java program to perform the following computations and display the results. In this
exercise, there is no need to store the results of the calculations in variables. Simply, output
the results to the console (MS DOS).
 Add two numbers
 Subtract two numbers
 Multiply two numbers
 Divide one number by another
 Return the remainder of two numbers
*/


public class JFT4Ex1 {
    public static void main(String[] args){
        
        int num1 = 60;
        int num2 = 200;
        System.out.println("JFT4Ex1: Performming computations and displaying results.");
        System.out.println("Adding two numbers: " + (num1 + num2));
        System.out.println("Subtracting two numbers: " + (num2 - num1));
        System.out.println("Multiplying two numbers: " + (num1 * num2));
        System.out.println("Dividing one number by another: " + (int) (num2 / num1));
        System.out.println("Returning the remainder of two numbers: " + (int) (num2 % num1));
    }
}
