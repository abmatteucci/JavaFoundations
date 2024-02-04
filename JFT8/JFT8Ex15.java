package JFT8;

/*
 * Write a Java program, which prints out all the even numbers from 1 to 100.
Use a while loop as part of the solution.
Save the program as JFT8Ex15.java
 */

public class JFT8Ex15 {

    public static void main(String[] args) {
        
        int i = 1;
        while (i <= 100) {
            if (i % 2 == 0){
                System.out.print(i + " ");
            }
            i++;
        }

    }
    
}
