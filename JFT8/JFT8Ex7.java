package JFT8;

/*
 * Using a for loop, display the following sequence of numbers on the same line:
300 250 200 150 100 50
Save the program as JFT8Ex7.java
 */

public class JFT8Ex7 {

    public static void main(String[] args) {
        
        int [] sequence = {300, 250, 200, 150, 100, 50};

        for (int num : sequence){
            System.out.print(num + " ");
        }

    }
    
}
