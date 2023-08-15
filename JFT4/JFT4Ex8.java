package JFT4;
/*
Exercise 8 – IncrementDecrement
Task:
Step 1: Using pen and paper, I would like you to work through the following question and
write out what you believe to be the correct answers, where prompted.
Step 2: Write the program out in Notepad / Notepad++. Compile and run the program in
MS-DOS. Test to see if you have the correct answers.
Save the program as JFT4Ex8
*/

// import java.util.ArrayList;
// import org.json.JSONObject;
// import org.json.JSONArray;

public class JFT4Ex8 {
    public static void main(String[] args){
        
        int c = 3;
        c++;

        System.out.println("The value of c is " + c); // 4
        int w = 0;
        w = ++c;
        System.out.println("The value of w is " + w); // 5
        System.out.println("The value of c is " + c); // 5
        int x = 0;
        x = c++;
        System.out.println("The value of x is " + x); // 5
        System.out.println("The value of c is " + c); // 6
        int y = 0;
        y = --c;

        System.out.println("The value of y is " + y); // 5
        System.out.println("The value of c is " + c); // 5

        int z = 10;
        z++;
        ++z;
        --z;
        int qq = ++z;
        z = c--;

        System.out.println("The value of z is " + z); // 5
        System.out.println("The value of c is " + c); // 4
        System.out.println("The value of qq is " + qq); // 12
    }
}
