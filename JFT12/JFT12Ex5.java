package JFT12;

/*
 *  I would like to write a Java program to wish the user a happy birthday. Assume that
the user’s name is Duke and that this value is stored in a String named userName.
Which method of the Java class should I use to append a new String, “ Happy
Birthday !!” to the existing String? Write a Java program to prove that you are right!
 Create a Java class named JFT12Ex5.java
 */

public class JFT12Ex5 {

    public static void main(String[] args) {
        
        String userName = new String("Duke");
        String hBmsg = " Happy Birthday !!";
        // Option 1
        System.out.printf("%s%s%n", userName, hBmsg);

        // Option 2
        System.out.println(userName.concat(hBmsg));

    }
    
}
