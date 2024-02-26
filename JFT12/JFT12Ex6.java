package JFT12;

/*
 * Assume that a user has entered a password of “javabeans”in a program. The value is
stored in a variable named userEnteredPassword. The actual password is
“JAVABEANs” and is stored in a variable named password. Which method of the
Java class should I use to compare the contents of the two String variables,
irrespective of case? Display an appropriate message to the user.
Create a Java class named JFT12Ex6.java
 */

public class JFT12Ex6 {

    public static void main(String[] args) {
        
        String userEnteredPassword = new String("javabeans");
        String actualPassword = "JAVABEANs";

        if (userEnteredPassword.equalsIgnoreCase(actualPassword)) {
            System.out.println("Log-on successful");
        }

    }
    
}
