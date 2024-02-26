package JFT12;

/*
 * Assume that a Java program contains the following String.
String risingFootballStar = “Eden Hazard”;
Write a Java program using a String method to extract the following characters from the
String,
 “ en Hazard”
Store this newly created String in a separate variable named stringExtract and display its
value in the console.
Create a Java class named JFT12Ex11.java
 */

public class JFT12Ex11 {

    public static void main(String[] args) {
        
        String risingFootballStar = "Eden Hazard";
        String stringExtract = risingFootballStar.substring(2);

        System.out.println(stringExtract);

    }
    
}
