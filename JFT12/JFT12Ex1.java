package JFT12;

public class JFT12Ex1 {
    public static void main(String[] args){

    String x = new String ("Java");
    x = x.concat(" Rules");
    System.out.println("x = " + x); // "x = Java Rules"
    x.toUpperCase(); // to uppercase x, but without saving to x variable
    System.out.println("x = " + x); // "x = Java Rules"
    x.replace('a', 'X'); // replacing a to 'X', but without saving to x as well...
    System.out.println("x = " + x); // "x = Java Rules"
    x = x.concat(" Rules!");
    System.out.println("x = " + x); // "x = Java Rules Rules!"
    }// method
}// class