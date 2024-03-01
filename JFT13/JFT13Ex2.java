package JFT13;

import java.util.Random;

/*
 * Create a Java program, which will generate and display a random number between 1 to 10
(inclusive).
Use the Random class as part of your solution. Run the program several times to see
random numbers being generated.
Save your class as JFT13Ex2.java
 */

public class JFT13Ex2 {

    public static void main(String[] args) {
        Random rdn = new Random();
        int intRrdn = rdn.nextInt(10) + 1;

        System.out.println(intRrdn);
    }
    
}
