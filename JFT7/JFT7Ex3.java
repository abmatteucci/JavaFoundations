/*
Write a java program to store the age of 6 students


*/

public class JFT7Ex3 {

    public static void main (String args []){
        int [] ages = {16, 16, 17, 16, 17, 16};
        System.out.println("There is " + ages.length + " students in the class.");
        System.out.println("Their ages are: ");
        for (int age : ages){
            System.out.println(age);
        }
    }
} 