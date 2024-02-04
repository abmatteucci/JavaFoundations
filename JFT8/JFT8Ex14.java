package JFT8;

/*
 * Write a Java program, which prints out the numbers 5 10 15 20 25 30 one
number per line using a while loop.
Save the program as JFT8Ex14.java
 */

public class JFT8Ex14 {

    public static void main(String[] args) {
        
        int [] numbers = {5, 10, 15, 20, 25, 30};
        int i = 0;

        while (i < numbers.length){
            System.out.println(numbers[i]);
            i++;
        }

    }
    
}
