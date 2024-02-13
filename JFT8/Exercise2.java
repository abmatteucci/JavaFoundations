package JFT8;

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

        // Processa cada pedido de empréstimo
        for (int i = 0; i < friendCount; i++) {
            double requestedAmount = loanRequests[i];
            Friend friend = new Friend("Amigo " + Friend.getNextId(), requestedAmount);

            // Tenta aprovar o empréstimo
            boolean result = fund.tryLoan(friend);

            // Exibe o resultado para o amigo
            if (result) {
                System.out.println("Amigo " + friend.getId() + ": Empréstimo de " + friend.getLoanRequest() + "€ aprovado.");
            } else {
                System.out.println("Amigo " + friend.getId() + ": Empréstimo negado. Saldo insuficiente.");
                Log.log("Empréstimo negado para amigo " + friend.getId() + ". Saldo insuficiente.");
            }
        }

        // Mostra o saldo final
        System.out.println("\nSaldo final: " + fund.getBalance() + "€");
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

    public static void log(String message) {
        System.out.println("[LOG] " + message);
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

    public double getLoanRequest() {
        return loanRequest;
    }

    public static int getNextId() {
        return nextId;
    }
}

