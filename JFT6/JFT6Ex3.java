package JFT6;

import java.util.ArrayList;

/*
Create another version of the Fisherman’s permit program to comply with the following
logic.
 A fisherman is only allowed to go on a fishing trip if he holds a fishing permit and is aged over
18.
 Create two variables, one to store the permit status (store the value, false) and another to
store the age of the person (store the value, 19).
 Use a single if statement as part of the solution.
 Save the program as JFT6Ex3.java
 */

public class JFT6Ex3 {
    public static void main(String[] args){

        ArrayList<Fisherman> lFishermans = new ArrayList<>();

        Fisherman fisherman1 = new Fisherman("Antonio", "Matteucci", "abmatteucci@gmail.com", 41, true);
        Fisherman fisherman2 = new Fisherman("Fernando", "Matteucci", "fernando.matteucci@gmail.com", 38, true);
        Fisherman fisherman3 = new Fisherman("Bruno", "Silva", "bbsilva@gmail.com", 23, true);
        Fisherman fisherman4 = new Fisherman("Théo", "Matteucci", "abmatteucci@gmail.com", 3, false);
        Fisherman fisherman5 = new Fisherman("Geraldo", "Silva", "abmatteucci@gmail.com", 63, true);
        Fisherman fisherman6 = new Fisherman("Sarah", "Matteucci", "sarah.quilice@gmail.com", 39, true);    

        lFishermans.add(fisherman1);
        lFishermans.add(fisherman2);
        lFishermans.add(fisherman3);
        lFishermans.add(fisherman4);
        lFishermans.add(fisherman5);
        lFishermans.add(fisherman6);

        ArrayList<Fisherman> permitedFishermans = new ArrayList<>();

        if (lFishermans.size() >= 5){
            for (Fisherman fisher : lFishermans){
                if (fisher.hasPermit && fisher.age >= 18){
                    permitedFishermans.add(fisher);
                }
            }
            if (permitedFishermans.size() < 5){
                System.out.println("Your trip has not a minimum members with fishing permission (5 permited fishermans).");
            } else {
                System.out.println("Your trip was successfully created!");
                System.out.println();
                System.out.println("Trip Members List: ");
                for (Fisherman fisher : permitedFishermans){
                    System.out.println("Name: " + fisher.getFullName());
                }
            }
        } else {
            System.out.println("Your trip has not a minimum members yet.");
        }

    }
}

class Fisherman{

    String Firstname;
    String FamilyName;
    String email;
    int age;
    boolean hasPermit;

    public Fisherman(String firstname, String familyname, String email, int age, boolean hasPermit){
        this.Firstname = firstname;
        this.FamilyName = familyname;
        this.email = email;
        this.age = age;
        this.hasPermit = hasPermit;
    }

    public boolean getHasPermit(){
        return this.hasPermit;
    }

    public String getFullName(){
        String fullname = new String(FamilyName + ", " + Firstname);
        return fullname;
    }

    public String getEmail(){
        return this.email;
    }

    public int getAge(){
        return this.age;
    }
}
