package JFT8;

/*
 * Create a new version of Exercise 11 (For Loop Exercises Sheet). Remove the for
loop, replace it with a while loop.
Save the program as JFT8Ex19.java
 */

public class JFT8Ex19 {

    public static void main(String[] args) {
        
        char[] responses = {'Y', 'Y', 'Y', 'Y', 'Y', 'Y', 'N', 'Y', 'N', 'N'};
        int i = 0;
        int positives = 0;
        while (i < responses.length){
            Boolean isPositive = (responses[i] == 'Y');
            if (isPositive){
                positives++;
            }
            if (positives >= 7){
                break;
            }
            i++;
        }
        if (positives >=7){
            System.out.println("The fishing trip is going ahead!");
        } else {
            System.out.println("Your fishing trip will not go ahead.");
        }

    }
    
}
