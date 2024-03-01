package JFT13;

/*
 * Create a Java program, which will separately find the maximum and minimum of two float
variables.
Declare the following variables.
 float num1 = 10.05f;
 float num2 = 20.34f;
Use appropriate methods in the Math class as part of your solution. Display the results in the
console.
Save your class as JFT13Ex1.java
 */

public class JFT13Ex1 {

    public static void main(String[] args) {
        
        float num1 = 10.05f;
        float num2 = 20.34f;

        System.out.println("Max No. is: " + Math.max(num1, num2));
        System.out.println("Min No. is: " + Math.min(num1, num2));


    }
    
}
