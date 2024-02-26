package JFT12;

/*
 * Assume that a Java program contains the following String.
String tale = “Curiosity killed the cat!”;
You need to substitute every occurrence of the letter ‘k’ with the character ‘f’. Which method
of the String class can you use to achieve this?
Create a Java program to prove that you are right.
Create a Java class named JFT12Ex8.java
 */

public class JFT12Ex8 {

    public static void main(String[] args) {
        
        String tale = "Curiosity killed the cat!";

        System.out.println(tale.replace('k', 'f'));

    }
    
}
