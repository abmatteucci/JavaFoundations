package JFT8;

/*
 * Using a for loop, display the following sequence of numbers on the same line.
5 10 15 20 25 30
Save the program as JFT8Ex6.java
 */

public class JFT8Ex6 {

    public static void main(String[] args) {
        
        int [] sequence = {5, 10, 15, 20, 25, 30};

        for (int num : sequence){
            System.out.print(num + " ");
        }
    }
    
}
