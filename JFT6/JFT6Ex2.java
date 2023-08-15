package JFT6;

import java.util.ArrayList;

/*
A fishing trip will only go ahead if there are more than five registrations. Assume that only
two people want to go on the trip (store this information in a variable). Create a Java
program utilising an if-else statement to determine if the trip is to go ahead. Display an
appropriate message in the console.
 Save the program as JFT6Ex2.java
 */

public class JFT6Ex2 {
    public static void main(String[] args){

        ArrayList<Fisherman> lFishermans = new ArrayList<>();

        Fisherman fisherman1 = new Fisherman("Antonio", "Matteucci", "abmatteucci@gmail.com", true);
        Fisherman fisherman2 = new Fisherman("Fernando", "Matteucci", "fernando.matteucci@gmail.com", true);
        Fisherman fisherman3 = new Fisherman("Bruno", "Silva", "bbsilva@gmail.com", true);
        Fisherman fisherman4 = new Fisherman("Théo", "Matteucci", "abmatteucci@gmail.com", false);
        Fisherman fisherman5 = new Fisherman("Geraldo", "Silva", "abmatteucci@gmail.com", true);
        

        lFishermans.add(fisherman1);
        lFishermans.add(fisherman2);
        lFishermans.add(fisherman3);
        lFishermans.add(fisherman4);
        lFishermans.add(fisherman5);

        ArrayList<Fisherman> permitedFishermans = new ArrayList<>();

        if (lFishermans.size() >= 5){
            for (Fisherman fisher : lFishermans){
                if (fisher.hasPermit){
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
    boolean hasPermit;

    public Fisherman(String firstname, String familyname, String email, boolean hasPermit){
        this.Firstname = firstname;
        this.FamilyName = familyname;
        this.email = email;
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
}
