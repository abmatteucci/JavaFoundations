/*
• Write a Java program to store the names of the four Irish provinces (Connacht, Leinster,
Munster and Ulster).
• Use an array as part of your solution. Declare, initialise and populate the array on one
line using the comma separated approach.
• Display the number of Irish provinces and the names stored in the array, using a series of
System.out.println() statements.
• Save the program as JFT7Ex4.java
*/

public class JFT7Ex4 {

    public static void main (String args []){
        String [] provinces = {"Connacht", "Leinster", "Munster", "Ulster"};
        System.out.println("There are " + provinces.length + " Irish provinces.");
        System.out.println("The provinces are: ");
        for (String province : provinces){
            System.out.println(province);
        }
    }
} 