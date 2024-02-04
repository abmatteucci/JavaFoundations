package JFT8;

/*
 * Write a Java program which determines if a person is entitled to vote. A person is entitled to
vote if they are aged 18 years or over.
Create an array named ‘ages’ to store the following ages.
34
16
31
19
30
19
32
11
12
13
Create a second array to store the corresponding names.
John Welsh
Frank Hayes
Anna Davis
Jennifer Burns
Francis Burke
Fred Smith
Phillipa Smith
Jason Button
Ian Hayes
Derva Conway
Use a for loop to iterate through the ‘ages’ array. Check the value of the age stored in each
array index position. If age is less than 18, no message should be displayed. In this case, use
the continue keyword to move on to the next iteration of the loop.
However, if age is greater than 18, display the name of the person along with the message,
“You are eligible to vote. Proceed to your polling station”.
Save the program as JFT8Ex12.java
 */

public class JFT8Ex12 {

    public static void main(String[] args) {
        
        int [] ages = {34, 16, 31, 19, 30, 19, 32, 11, 12, 13};

        String [] names = {"John Welsh", "Frank Hayes", "Anna Davis", "Jennifer Burns", "Francis Burke", "Fred Smith", "Phillipa Smith", "Jason Button", "Ian Hayes", "Derva Conway"};

        for (int i = 0; i < ages.length; i++){
            if (ages[i] <= 18){
                continue;
            } else {
                System.out.println("Voter: " + names[i] + " - You are eligible to vote. Proceed to your polling station.");
            }
        }

    }
    
}
