package JFT8;

/*
 * Create a for loop that counts down the USA Billboard Top 5 music artists of the 1980s!
Store the names of the groups / artists in an array.
Here are the artists and their positions:
No 5: Michael Jackson
No 4: Frankie Goes To Hollywood
No 3: Queen
No 2: Simple Minds
No 1: Rick Astley
 */

public class JFT8Ex5 {

    public static void main(String[] args) {
        
        String [] topfive = {"Rick Astley", "Simple Minds", "Queen", "Frankie Goes To Hollywood", "Michael Jackson"};

        for (int i = topfive.length -1; i >= 0; i--) {
            System.out.println("Position: " + (i + 1) + " Artist: " + topfive[i]);
        }

    }
    
}
