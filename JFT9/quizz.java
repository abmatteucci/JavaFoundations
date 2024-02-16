package JFT9;

import java.util.ArrayList;

public class quizz {

    public static void main(String[] args) {
        // ArrayList<String> names = new ArrayList<String>();

        // names.add("Cindy");
        // names.add("Dave");
        // names.add("John");
        // names.add("Mandy");

        // for(String s:names){
        //     System.out.println(s);
        // }// for loop

        // ArrayList<String> names = new ArrayList<String>();

        // names.add("Cindy");
        // names.add("Dave");
        // names.add("John");
        // names.add("Mandy");

        // names.add(2,"Billy");

        // for(String s:names){
        //     System.out.println(s);
        // }// for loop

        // ArrayList<String> names = new ArrayList<String>();

        // names.add("Cindy");
        // names.add("Dave");
        // names.add("John");
        // names.add("Mandy");

        // System.out.println(names.contains("Davey"));       // ******prints true in console******
        
        // ArrayList<String> names = new ArrayList<String>();

        // names.add("Cindy");
        // names.add("Dave");
        // names.add("John");
        // names.add("Mandy");
     
        // System.out.println(names.get(2));       // ****** Prints Dave to the console ******

        // ArrayList<String> names = new ArrayList<String>();

        // names.add("Cindy");
        // names.add("Dave");
        // names.add("John");
        // names.add("Mandy");

        // names.remove(2);

        // System.out.println(names.indexOf("Dave"));       // ****** Prints 2 in the console ******
        
        ArrayList<String> names = new ArrayList<String>();

        names.add("Cindy");
        names.add("Dave");
        names.add("John");
        names.add("Mandy");

        names.remove(2);

        System.out.println(names.get(2));       // ****** Prints Mandy to the console ******
    }
    
}
