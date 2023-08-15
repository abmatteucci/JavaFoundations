package JFT4;
/*
Write a program that declares a variable to store the number of minutes worked on a job
and assign it a value.
Now, convert the number of minutes into hours and minutes.
For example, 199 minutes becomes 3 hours and 19 minutes.
Make use of variables in your solution.
Save the program as JFT4Ex4.java
*/


public class JFT4Ex4 {
    public static void main(String[] args){
        
        System.out.println("JFT4Ex4: Storing the number of minutes worked on a job\n" + //
                "and assign it a value.");
        String repeated = new String(new char[20]).replace("\0", "*");
        MinutesToTime minutes = new MinutesToTime(199);
        System.out.println(repeated + "Convert minutes to time" + repeated);
        System.out.println("Initial qty. in minutes: " + minutes.initialMinutes + " minutes.");
        System.out.println("Hours: " + minutes.getHours());
        System.out.println("Minutes: " + minutes.getMinutes());
        System.out.println("Seconds: " + minutes.getSeconds());
        
    }
}

class MinutesToTime {
    int initialMinutes;
    int hoursQty;
    int minutesQty;
    int secondsQty = 0;

    public MinutesToTime(int minutesQty){
        this.initialMinutes = minutesQty;
        if (minutesQty >= 60) {
            this.hoursQty = (int) (minutesQty / 60);
            if ((minutesQty % 60) > 0) {
                this.minutesQty = minutesQty % 60;
            }
            this.minutesQty = minutesQty - (this.hoursQty * 60);
        } else {
            this.minutesQty = minutesQty;
        }
    }

    public int getHours(){
        return this.hoursQty;
    }

    public int getMinutes(){
        return this.minutesQty;
    }

    public int getSeconds(){
        return this.secondsQty;
    }
}