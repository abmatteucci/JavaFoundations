package JFT8;

/*
 * Write a Java program that uses an array to store the names of the following colours.
 Blue, Orange, Yellow, Green, White, Red, Black;


Use an enhanced for loop, to display the contents of the array on separate lines in the
console.
Save the program as JFT8Ex8.java
 */

public class JFT8Ex8 {

    public static void main(String[] args) {
        
        String [] colors = {"Blue", "Orange", "Yellow", "Green", "White", "Red", "Black"};

        for (String color : colors){
            System.out.println(color);
        }

    }
    
}
