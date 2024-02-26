package JFT12;

/*
 * Assume that a Java program contains the following String.
String name = “ Christopher N. Cross “;
In the program, subsequent code has been written to remove the leading and trailing white
spaces. The number of characters in the new string is then displayed in the console.
Create a Java class named JFT12Ex10.java
 */

public class JFT12Ex10 {

    public static void main(String[] args) {
        
        String name = " Christopher N. Cross ";

        System.out.printf("No. of characters contained in the name: %s is %d.", name.strip(), name.strip().length());

    }
    
}
