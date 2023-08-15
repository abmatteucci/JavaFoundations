package JFT4;
/*
Write a program to calculate the total value of an investment.
Assume the amount of the initial investment is €1000. Assume that the investment will
earn interest at a rate of 5%. How much interest will be earned? What is the total value of
the investment including interest? Make use of variables in your solution.
Output to the console:
 Principal Sum Invested
 Interest Rate
 Total Value of Investment
Save the program as JFT4Ex5.java
*/


public class JFT4Ex5 {
    public static void main(String[] args){
        
        System.out.println("JFT4Ex5: Calculating the total value of an investment.");
        String repeated = new String(new char[20]).replace("\0", "*");
        Investment investiment = new Investment(1000, 0.05f);
        System.out.println(repeated + "Investiment Calculator" + repeated);
        System.out.println("Principal Sum Invested: " + investiment.getInitial() + " euro.");
        System.out.println("The rate of interest is: " + investiment.getEstimatedEarnRate());
        System.out.println("Interest Earned: " + investiment.getInterest() + " euro.");
        System.out.println("Total Value of Investment: " + investiment.getAmount() + " euro.");
        
    }
}

class Investment {
    float initialInvestment;
    float interestedEarnRate;
    float interest;
    float estimatedAmount;

    public Investment(float initial, float earnRate) {
        this.initialInvestment = initial;
        this.interestedEarnRate = earnRate;
        this.interest = initial * earnRate;
        this.estimatedAmount = this.interest + initial;
    }

    public float getInitial(){
        return this.initialInvestment;
    }

    public float getEstimatedEarnRate(){
        return this.interestedEarnRate;
    }

    public float getInterest(){
        return this.interest;
    }

    public float getAmount(){
        return this.estimatedAmount;
    }
}