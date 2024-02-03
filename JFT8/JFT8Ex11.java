package JFT8;

/*
 * Imagine that a fishing trip will only go ahead if there are seven positive responses.
Create an array to store the following character values (the data type of the array should be
char, and the size / length of the array, 10).
Y
Y
Y
Y
Y
Y
N
Y
N
N
Determine if the fishing trip will go ahead. Make use of the break keyword in your solution.
Save the program as JFT8Ex11.java
 */

public class JFT8Ex11 {

    public static void main(String[] args) {
        
        char[] responses = {'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'N', 'Y', 'N', 'N'};

        int positives = 0;
        for (char res : responses){
            Boolean isPositive = (res == 'Y');
            if (isPositive){
                positives++;
            }
            if (positives >= 7){
                break;
            }
        }
        if (positives >=7){
            System.out.println("The fishing trip is going ahead!");
        } else {
            System.out.println("Your fishing trip will not go ahead.");
        }

    }
    
}
