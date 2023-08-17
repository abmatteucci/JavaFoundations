package JFT6;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;


/*
Create a Java program which stores the number of miles ran by a marathon runner.
Create a variable named noOfMilesCovered of type byte. Assign a value of 10 to the variable.
A marathon runner is entitled to a water break, when he/she has covered the following number of
miles: 5 | 10 | 15 | 20 | 25.
If the marathon runner happens to be at any one of these water break markers, display the message,
“Water is available at this mark”.
Otherwise, display the message, “No water is available at this mark”.
Solve the problem using either:
• A switch statement
• If-Else-if-Else statement
• Save the program as JFT6Ex13.java
 */

public class JFT6Ex13{
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        String repeated = new String(new char[20]).replace("\0", "*");
        String repeated_blank = new String(new char[10]).replace("\0", " ");
        
        // Create Marathon
        ArrayList<Runner> marathon = generateMarathon(1000, 42);
        Boolean active = true;

        while (active){
            
            System.out.println(repeated + "Marathon" + repeated);
            System.out.println(repeated + repeated + repeated);
            System.out.println();
            
            System.out.println("Insira o comando: ");
            System.out.println("Para editar o Marital Status, 'E'" + 
                            "\npara Resumir o status da maratona 'R' e" + 
                            "\npara sair digite 'S'.");
            System.out.println();
            String inputStr = scanner.next();
            System.out.println();
            scanner.nextLine();
            
            
            switch (inputStr) {
                case "E":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Editar o Status:");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    System.out.println("O status marital atual é: " + getMaritalStatusDescription(p1.maritalStatus));
                    System.out.println("Insira o novo Status: " + 
                                    "\n'S' (Single); " + 
                                    "\n'D' (Divorced);" +
                                    "\n'M' (Married);" + 
                                    "\n'W' (Widowed)");
                    String status = scanner.next();
                    char statusChar = status.charAt(0);
                    
                    p1.setPersonMaritalStatus(statusChar);
                    System.out.println("Status Marital modificado com sucesso!");
                    System.out.println("Novo status: " + getMaritalStatusDescription(p1.getPersonMaritalStatus()));
                    break;
                case "R":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Status Marital atual:");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    //System.out.println("");
                    System.out.println("Status marital: " + getMaritalStatusDescription(p1.maritalStatus));
                    System.out.println();
                    break;
                case "S":
                    active = false;
                    System.out.println("Saindo do programa Marital Status.");
                    System.out.println();
                    break;

                default:
                    break;
            
            }
        
        }
        scanner.close();
    }

    private static ArrayList<Runner> generateMarathon(int runners, int miles){
        ArrayList<Runner> marathon = new ArrayList<>();
        for (int qty = 1; qty <= runners; qty++){
            Runner r = new Runner(miles);
            Skills s = new Skills(qty);
            r.setSkills(s);
            marathon.add(r);
        }
        return marathon;
    }
}

class Skills{
    Random rd = new Random();
    int id;
    int staminaAbs;
    float staminaPercentage;
    float staminaLossRate;
    float staminaRecovery;
    float maxSpeed;

    public Skills(int id){
        this.id = id;
        this.staminaAbs = generateStaminaAbs(16_000, 30_000);
        this.staminaPercentage = generateStaminaPercentage();
        this.staminaLossRate = generateStaminaLossRate();
        this.staminaRecovery = generaStaminaRecovery();
        this.maxSpeed = generateMaxSpeed(18.5f, 25.5f);
    }

    private float generateStaminaPercentage(){
        float startValue = rd.nextFloat();
        while(startValue < 0.85f){
                startValue = rd.nextFloat();
            }
        return startValue;
    }

    private float generateStaminaLossRate(){
        float loss = rd.nextFloat();
        while(loss > 0.1f){
            loss = rd.nextFloat();
        }
        return (loss > 0) ? loss : (loss + 0.01f);
    }

    private int generateStaminaAbs(int min, int max){
        int qty = rd.nextInt(max);
        while(qty < min){
            qty = rd.nextInt(max);
        }
        return qty;
    }

    private float generaStaminaRecovery(){
        float recovery = rd.nextFloat();
        while(recovery > 0.35f){
            recovery = rd.nextFloat();
        }
        return recovery;
    }

    private float generateMaxSpeed(float min, float max){
        float speedFactor = rd.nextFloat();
        int speedInt = rd.nextInt((int) max);
        float speed = 0f;
        while (speedInt > (int) max | speed < min){
            if ((speedInt + speedFactor) > min){
                speed = (float) (speedInt + speedFactor);
            }
            speedFactor = rd.nextFloat();
            speedInt = rd.nextInt((int) max);
        }
        return speed;
    }
}

class Runner{
    Random random = new Random();
    int id = random.nextInt(100_000);
    float miles;
    Skills skills;
    int runnerSkillFunc;

    public Runner(float miles){
        this.miles = miles;
    }

    public int getRunnerId(){
        return this.id;
    }

    public float getRanStatus(){
        return this.miles;
    }

    public void setRanStatus(float miles){
        this.miles = miles;
    }

    public void setRunnerSkillStd(int skill){
        this.runnerSkillFunc = skill;
    }

    public void setSkills(Skills skills){
        this.skills = skills;
    }
}

