package JFT5;
/*
Using a pen and paper, initially work through the following questions and note your
answers.
For each question, ask yourself, will the code compile? Do I need to put in a cast?
When you have answered each question, create the program using Notepad++.
Check your answers to make sure that you are correct!
Save the program as JFT5Ex1.java
*/

// import java.util.ArrayList;
// import org.json.JSONObject;
// import org.json.JSONArray;

public class JFT5Ex1 {
    public static void main(String[] args){
        
        // Q1: Do I need a cast? No
        byte b = 4;
        int c = b;
        System.out.println("The variavle b is: " + b);
        System.out.println("The variavle c is: " + c);
        // Q2: Do I need a cast? No
        short s = 32000;
        double d = (double) s;
        System.out.println("The variavle s is: " + s);
        System.out.println("The variavle d is: " + d);
        // Q3: Do I need a cast? Yes
        int i = 100_000; 
        byte bb = (byte) i;
        System.out.println("The variavle i is: " + i);
        System.out.println("The variavle bb is: " + bb);
        // Q4: Do I need a cast? Yes
        int ii = 100_000;
        byte bbb = (byte) ii;
        System.out.println("The variavle ii is: " + ii);
        System.out.println("The variavle bbb is: " + bbb);
        // Q5: Do I need a cast? Yes
        int j = 3;
        short jj = (short) j;
        System.out.println("The variavle j is: " + j);
        System.out.println("The variavle jj is: " + jj);
        // Q6: Do I need a cast? No
        int k = 45000;
        float f = k;
        System.out.println("The variavle k is: " + k);
        System.out.println("The variavle f is: " + f);
        // Q7: Do I need a cast? Yes
        float ff = 1.5f;
        int z = (int) ff; 
        System.out.println("The variavle ff is: " + ff);
        System.out.println("The variavle z is: " + z);
    }
}
