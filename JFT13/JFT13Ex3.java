package JFT13;

import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * Create a Java program, which asks the user to enter a decimal
number (create a Scanner object to facilitate input).
In this exercise, you will practice formatting decimal numbers.
Display the user entry rounded to two decimal places using:
(A): A DecimalFormat object.
(B): The printf() method.
Save your class as JFT13Ex3.java
 */

public class JFT13Ex3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat(".00");

        float input = 0.00f;

        System.out.print("Enter a decimal no.: ");

        // Certifique-se de ler uma entrada válida (float)
        while (!scanner.hasNextFloat()) {
            System.out.println("Invalid input error. Please, type a valid decimal number.");
            scanner.next(); // Limpa a entrada inválida
        }

        input = scanner.nextFloat();

        System.out.printf("Using decimal format object: %s\n", decimalFormat.format(input));
        System.out.printf("Using printf method %.2f", input);

        scanner.close();

    }
    
}
