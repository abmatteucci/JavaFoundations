package JFT12;

/*
 * Assume that a Java program contains the following Strings.
String message1 = “Message in a bottle”;
String message2 = “Message in a jar”;
Which method of the String class can I use to determine which String object has the largest
length? Create a Java program which displays the length of both Strings and the message
with the greatest length.
Create a Java class named JFT12Ex7.java
 */

public class JFT12Ex7 {

    public static void main(String[] args) {
        
        String message1 = "Message in a bottle";
        String message2 = "Message in a jar";

        System.out.printf("Message 1 lenght: %d chars.%n", message1.length());
        System.out.printf("Message 2 lenght: %d chars.%n", message2.length());

        if (message1.length() > message2.length()){
            System.out.printf("%s is longer than %s%n", message1, message2);
        } else if (message2.length() > message1.length()){
            System.out.printf("%s is longer than %s%n", message1, message2);
        } else {
            System.out.printf("%s and %s have same lenght%n", message1, message2);
        }

    }
    
}
