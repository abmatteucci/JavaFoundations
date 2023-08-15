package JFT6;
/*
Quizz
Topic 6.
*/

// import java.util.ArrayList;
// import org.json.JSONObject;
// import org.json.JSONArray;

public class QuizzTopic6 {
    public static void main(String[] args){

        String repeated = new String(new char[20]).replace("\0", "*");
        /*
        boolean and1 = true && true;
        boolean and2 = true & true;
        boolean and3 = false && false;
        boolean and4 = true & false;
        boolean and5 = false && true;
        boolean and6 = false & (5==5);

        boolean and7 = 5 && 6 ;
        boolean and8 = false & (10<6);
        boolean and9 = false & (2=5);
        if( (2 < 3) && (3 < 4) )
        System.out.println(“true”);
         */

        boolean and1 = true && true; //true
        boolean and2 = true & true; //true
        boolean and3 = false && false; //false
        boolean and4 = true & false; //false
        boolean and5 = false && true; //false
        boolean and6 = false & (5==5); //false
        boolean and7 = (5==5) && (6==6); //boolean and7 = 5 && 6; Compilation error. (int) 5, as well (int) 6, are not boolean and operator '&&' is an comparative operator with needs boolean operandus. Possible Fix: boolean and7 = (5==5) && (6==6);.  
        boolean and8 = false & (10<6); //false
        boolean and9 = false & (2==5); // boolean and9 = false & (2=5); Compilation error. Fix: boolean and9 = false & (2==5);

        System.out.println("Teste and1: " + and1);
        System.out.println("Teste and2: " + and2);
        System.out.println("Teste and3: " + and3);
        System.out.println("Teste and4: " + and4);
        System.out.println("Teste and5: " + and5);
        System.out.println("Teste and6: " + and6);
        System.out.println("Teste and7: " + and7);
        System.out.println("Teste and8: " + and8);
        System.out.println("Teste and9: " + and9);

        // Result: printed true
        if ( (2 < 3) && (3 < 4) ) { 
            System.out.println("true");
        }
        System.out.println(repeated);
        boolean and10 = true;
        int myCounter = 23;
        if( (and10==false) & (++myCounter==24) ){
            System.out.println("Expression is true"); //Not printed: and10 is true, so the operandus return false.
        }
        System.out.println(and10); //true
        System.out.println(myCounter); //24
        System.out.println("\n" + repeated);

        /*
        boolean or1 = true || true;
        boolean or2 = true | true;
        boolean or3 = true || false;
        boolean or4 = true | false;
        boolean or5 = false || true;
        boolean or6 = false | (5==5);
        boolean or7 = false || false;
        boolean or8 = false | (10<6);
         */

        boolean or1 = true || true;
        boolean or2 = true | true;
        boolean or3 = true || false;
        boolean or4 = true | false;
        boolean or5 = false || true;
        boolean or6 = false | (5==5);
        boolean or7 = false || false;
        boolean or8 = false | (10<6);
        System.out.println("Teste or1: " + or1); //true
        System.out.println("Teste or2: " + or2); //true
        System.out.println("Teste or3: " + or3); //true
        System.out.println("Teste or4: " + or4); //true
        System.out.println("Teste or5: " + or5); //true
        System.out.println("Teste or6: " + or6); //true
        System.out.println("Teste or7: " + or7); //false
        System.out.println("Teste or8: " + or8); //false
        System.out.println("\n" + repeated);
        System.out.println("What is the value of z?");
        int z = 5;
        if(z++ > 5 || ++z > 6) z++;
        System.out.println(z);  // z = 8

        System.out.println("\n" + repeated);
        System.out.println("What is the value of z?");
        int y = 5;
        z = y++; // int z = 5++; Compiling error: '5' is not a variable to incremment operator. Fix: int y = 5; int z = y++;
        if(--z > 5 | ++z > 6) --z;
        System.out.println(z); //Fixed: z = 5
        System.out.println("\n" + repeated);
        System.out.println("What is the value of z?");
        System.out.println("What is the value of y?");
        y = 2;
        z = y++; // z = 2, y = 3
        //  z = 1   z = 2           y = 4
        if(--z > 2 | ++z > 2) --z; ++y;
        System.out.println("z is: " + z); // z = 2
        System.out.println("y is: " + y); //y = 4
    }
}
