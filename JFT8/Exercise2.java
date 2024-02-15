package JFT8;

import java.util.ArrayList;

/*
 * You have saved up an amount of money, €500. Being a kind person, you like to help
your friends by giving them small loans.
Your friends have asked if they can borrow the following amounts from you.
60,20,100,80,40,300,200,100.
Loans will be granted on a first come, first served basis.
Write a Java program, which processes these loan request amounts.
If there is enough money remaining in the kitty, the full amount of the loan request
should be granted.
If, however, the amount of the loan request exceeds the amount of money remaining:
• Whatever amount of money is left in the kitty should be given out.
For example, if the balance remaining is €200 and the loan request is for €300,
the balance remaining of €200 should be given out.
Any outstanding loan request amounts should then be displayed in the console.
Save the program as Exercise2.java.
Your solution must include the use of the following Java features:
• Arrays
• Looping constructs
• Decision making constructs
The desired program output is shown overleaf.
 */

public class Exercise2 {
    public static void main(String[] args) {
        // Creating PersonalFund
        PersonalFund fund = new PersonalFund(500.0);

        // Loan Asked for
        int friendCount = 8;
        double[] loanRequests = {60.0, 20.0, 100.0, 80.0, 40.0, 300.0, 200.0, 100.0};
        ArrayList<Double> unprocessedLoans = new ArrayList<>();
        ArrayList<Log> loggin = new ArrayList<>();

        System.out.println("Cash in the pot: " + fund.getBalance() + "\n");
        // Processing loan requests
        for (int i = 0; i < friendCount; i++) {
            
            double requestedAmount = loanRequests[i];
            Friend friend = new Friend("Friend " + Friend.getNextId(), requestedAmount);

            // Try fully loan request
            boolean result = fund.tryLoan(friend);

            // Exibe o resultado para o amigo
            if (result) {
                System.out.println("Friend " + friend.getId() + ": Loan amount requested €" + friend.getLoanRequest() + ". - Loan amount granted.");
                System.out.println("Cash in the pot: " + fund.getBalance());
                Log log = new Log(friend, requestedAmount, requestedAmount, result, result);
                loggin.add(log);
                System.out.println();
            } else {
                if (fund.getBalance() > 0){
                    
                    System.out.println("Friend " + friend.getId() + ": Loan amount requested €" + friend.getLoanRequest());
                    System.out.println("The exact loan request cannot be precessed in full (insufficent funds available).");
                    System.out.println("However, we will give you what we can... €" + fund.getBalance());
                    friend.setLoadRequest(fund.getBalance());
                    Log log = new Log(friend, requestedAmount, fund.getBalance(), true, false);
                    fund.tryLoan(friend);
                    loggin.add(log);
                    System.out.println();
                    // System.out.println("Cash in the pot: " + fund.getBalance());
                } else {
                    unprocessedLoans.add(requestedAmount);
                    Log log = new Log(friend, requestedAmount, fund.getBalance(), result, false);
                    loggin.add(log);
                }
                
            }
        }

        // Showing final balance
        System.out.println("\nCash remaining in the pot: " + fund.getBalance());
        System.out.println();
        if (unprocessedLoans.size() > 0){
            System.out.println("The following loan requests could not be facilitated:");
            for (double up : unprocessedLoans){
                System.out.println(up);
            }
        }

        System.out.println("\nLoggin\n");
        for (Log l : loggin){
            l.logStr();
        }
    }
}

class PersonalFund {

    private double balance;

    public PersonalFund(double initialBalance) {
        this.balance = initialBalance;
    }

    public boolean tryLoan(Friend friend) {
        double requestedAmount = friend.getLoanRequest();

        if (requestedAmount <= balance) {
            balance -= requestedAmount;
            return true;
        }

        return false;
    }

    public double getBalance() {
        return balance;
    }
}

class Log {
    public Friend friend;
    public double amountRequested;
    public boolean granted;
    public boolean fullGranted;
    public double amountGranted;

    public Log(Friend friend, double amountRequested, double amountGranted, boolean granted, boolean fullGranted){
        this.friend = friend;
        this.amountRequested = amountRequested;
        this.amountGranted = amountGranted;
        this.granted = granted;
        this.fullGranted = fullGranted;
    }

    public void logStr() {
        System.out.println("[LOG] " + this.friend.getFriendName() + ", requested amount: " + this.amountRequested + ", granted amount: " + this.amountGranted + ", is granted: " + this.granted + ", is fully granted: " + this.fullGranted);
    }
}

class Friend {

    private static int nextId = 1;

    private int id;
    private String name;
    private double loanRequest;

    public Friend(String name, double loanRequest) {
        this.id = nextId++;
        this.name = name;
        this.loanRequest = loanRequest;
    }

    public int getId() {
        return id;
    }

    public String getFriendName(){
        return name;
    }

    public double getLoanRequest() {
        return loanRequest;
    }

    public static int getNextId() {
        return nextId;
    }

    public void setLoadRequest(double loanRequest){
        this.loanRequest = loanRequest;
    }
}

