package JFT8;

/*
 * Print out the numbers 30,25,20,15,10,5 using a do while loop.
Save the program as JFT8Ex17.java
 */

public class JFT8Ex17 {

    public static void main(String[] args) {
        
        int [] numbers = {30,25,20,15,10,5};
        int i = 0;
        do {
            System.out.print(numbers[i] + " ");
            i++;
        } while (i < numbers.length);

    }
    
}
