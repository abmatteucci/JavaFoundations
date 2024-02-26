package JFT12;

/*
 * Create a Java program with a main method. Declare the following local variables in the main
method.
 String name = “Daniel Franks”;
 int age = 30;
 int averageAge = 23;
Using an if statement, determine if the age of Daniel Franks is greater or less than the average
age. 
Use the System.out.printf() method to display a message to the user.
Create a Java class named JFT12Ex12.java
 */

public class JFT12Ex12 {

    public static void main(String[] args) {
        
        String name = "Daniel Franks";
        int age = 30;
        int averageAge = 23;

        if (age > averageAge){
            System.out.printf("%s - your age of %d is greater than the average age (%d)", name, age, averageAge);
        } else {
            System.out.printf("%s - your age of %d is lower than the average age (%d)", name, age, averageAge);
        }
    }
    
}
