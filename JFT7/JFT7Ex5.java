/*
• Write a Java program to store information about university students. Specifically, you
wish to store information about:
o Name
o Age
o Degree Programme
• Create three separate arrays as part of your solution.
o The first array should stores names.
o The second array should stores ages.
o The third array should store degree
programmes.
• Populate the arrays with information about three students.
 John Hayes
 30
 Sports Science
 Michele Smyth
 24
 Law
 Frankie Walsh
 20
 Computer Science
• Display the number of students whose details are stored, and the contents of each array.
• Note:\t can be used to create a tab effect in the output. Add "\t" to your output string
after you output the contents of an array. For example: names[0] + "\t"
• Save the program as JFT7Ex5.java
*/

public class JFT7Ex5 {

    public static void main (String args []){
        String [] studentsNames = {"John Hayes", "Michele Smyth", "Frankie Walsh"};
        int [] ages = {30, 24, 20};
        String [] degrees = {"Sports Science", "Law", "Computer Science"};
        System.out.println("There are " + studentsNames.length + " Students.");
        
        for (int i = 0; i < studentsNames.length; i++){
            System.out.println("Name: " + studentsNames[i] + "\tAge: " + ages[i] + "\t\tDegree Programme: " + degrees[i]);
        }
    }
} 