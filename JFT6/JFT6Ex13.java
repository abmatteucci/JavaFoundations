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
        ArrayList<Runner> marathon = generateMarathon(10, 42);

        

        Boolean active = true;

        while (active){
            
            System.out.println(repeated + "Marathon" + repeated);
            System.out.println(repeated + repeated + repeated);
            System.out.println();
            
            System.out.println("Insira o comando: ");
            System.out.println("Para iniciar a maratona, 'I'" + 
                            "\npara Resumir o status da maratona 'R' e" + 
                            "\npara sair digite 'S'.");
            System.out.println();
            String inputStr = scanner.next();
            System.out.println();
            scanner.nextLine();
            
            
            switch (inputStr) {
                case "I":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Iniciar a maratona:");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    System.out.println("Iniciada!!");
                    System.out.println();
                    for (Runner r : marathon){
                        r.setStart(true);
                        Thread thread1 = new Thread(r);
                        thread1.start();
                        System.out.println(r.showRunner());
                    }
                    MarathonStatusThread statusThread = new MarathonStatusThread(marathon);
                    statusThread.start();
                    break;
                case "R":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Status dos atletas:");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    //System.out.println("");
                    //System.out.println("Status marital: " + getMaritalStatusDescription(p1.maritalStatus));
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

class MarathonStatusThread extends Thread {
    private ArrayList<Runner> marathon;

    public MarathonStatusThread(ArrayList<Runner> marathon) {
        this.marathon = marathon;
    }

    @Override
    public void run() {
        String repeated = new String(new char[20]).replace("\0", "*");
        while (true) {
            //System.out.println(repeated + "Status da Maratona" + repeated);
            //System.out.println(repeated + repeated + repeated);
            //System.out.println();

            for (Runner r : marathon) {
                if ((r.getRanStatus() < (5f + (5f * 0.05f)) && r.getRanStatus() > (5f - (5f * 0.05f))) && 
                    r.recovered == false){
                    r.setStamina(
                        (r.skills.staminaRecovery * r.skills.maxStamina) + r.stamina
                    );
                    r.setRecovery(true);
                    System.out.println("Runner: " + r.getRunnerId() + " | " +
                                    "Run: " + r.getRanStatus() + " | " +
                                    "Stamina: " + r.stamina + " | " +
                                    "Stamina Loss: " + r.skills.staminaLossRate + " | " +
                                    "Recovered: " + (r.recovered ? "yes" : "no") + " | " +
                                    "Running: " + (r.start ? "on" : "off"));
                    
                } else if (((r.getRanStatus() < (10f + (10f * 0.05f)) && r.getRanStatus() > (10f - (10f * 0.05f))) && 
                    r.recovered == false)){
                        r.setStamina(
                        (r.skills.staminaRecovery * r.skills.maxStamina) + r.stamina
                    );
                    r.setRecovery(true);
                    System.out.println("Runner: " + r.getRunnerId() + " | " +
                                    "Run: " + r.getRanStatus() + " | " +
                                    "Stamina: " + r.stamina + " | " +
                                    "Stamina Loss: " + r.skills.staminaLossRate + " | " +
                                    "Recovered: " + (r.recovered ? "yes" : "no") + " | " +
                                    "Running: " + (r.start ? "on" : "off"));
                } else if (((r.getRanStatus() < (15f + (15f * 0.05f)) && r.getRanStatus() > (15f - (15f * 0.05f))) && 
                    r.recovered == false)){
                        r.setStamina(
                        (r.skills.staminaRecovery * r.skills.maxStamina) + r.stamina
                    );
                    r.setRecovery(true);
                    System.out.println("Runner: " + r.getRunnerId() + " | " +
                                    "Run: " + r.getRanStatus() + " | " +
                                    "Stamina: " + r.stamina + " | " +
                                    "Stamina Loss: " + r.skills.staminaLossRate + " | " +
                                    "Recovered: " + (r.recovered ? "yes" : "no") + " | " +
                                    "Running: " + (r.start ? "on" : "off"));
                } else if (((r.getRanStatus() < (20f + (20f * 0.05f)) && r.getRanStatus() > (20f - (20f * 0.05f))) && 
                    r.recovered == false)){
                        r.setStamina(
                        (r.skills.staminaRecovery * r.skills.maxStamina) + r.stamina
                    );
                    r.setRecovery(true);
                    System.out.println("Runner: " + r.getRunnerId() + " | " +
                                    "Run: " + r.getRanStatus() + " | " +
                                    "Stamina: " + r.stamina + " | " +
                                    "Stamina Loss: " + r.skills.staminaLossRate + " | " +
                                    "Recovered: " + (r.recovered ? "yes" : "no") + " | " +
                                    "Running: " + (r.start ? "on" : "off"));
                } else if (((r.getRanStatus() < (25f + (25f * 0.05f)) && r.getRanStatus() > (25f - (25f * 0.05f))) && 
                    r.recovered == false)){
                        r.setStamina(
                        (r.skills.staminaRecovery * r.skills.maxStamina) + r.stamina
                    );
                    r.setRecovery(true);
                    System.out.println("Runner: " + r.getRunnerId() + " | " +
                                    "Run: " + r.getRanStatus() + " | " +
                                    "Stamina: " + r.stamina + " | " +
                                    "Stamina Loss: " + r.skills.staminaLossRate + " | " +
                                    "Recovered: " + (r.recovered ? "yes" : "no") + " | " +
                                    "Running: " + (r.start ? "on" : "off"));
                } else if (((r.getRanStatus() < (30f + (30f * 0.05f)) && r.getRanStatus() > (30f - (30f * 0.05f))) && 
                    r.recovered == false)){
                        r.setStamina(
                        (r.skills.staminaRecovery * r.skills.maxStamina) + r.stamina
                    );
                    r.setRecovery(true);
                    System.out.println("Runner: " + r.getRunnerId() + " | " +
                                    "Run: " + r.getRanStatus() + " | " +
                                    "Stamina: " + r.stamina + " | " +
                                    "Stamina Loss: " + r.skills.staminaLossRate + " | " +
                                    "Recovered: " + (r.recovered ? "yes" : "no") + " | " +
                                    "Running: " + (r.start ? "on" : "off"));
                } else if (((r.getRanStatus() < (35f + (35f * 0.05f)) && r.getRanStatus() > (35f - (35f * 0.05f))) && 
                    r.recovered == false)){
                        r.setStamina(
                        (r.skills.staminaRecovery * r.skills.maxStamina) + r.stamina
                    );
                    r.setRecovery(true);
                    System.out.println("Runner: " + r.getRunnerId() + " | " +
                                    "Run: " + r.getRanStatus() + " | " +
                                    "Stamina: " + r.stamina + " | " +
                                    "Stamina Loss: " + r.skills.staminaLossRate + " | " +
                                    "Recovered: " + (r.recovered ? "yes" : "no") + " | " +
                                    "Running: " + (r.start ? "on" : "off"));
                } else if (((r.getRanStatus() < (40f + (40f * 0.05f)) && r.getRanStatus() > (40f - (40f * 0.05f))) && 
                    r.recovered == false)){
                        r.setStamina(
                        (r.skills.staminaRecovery * r.skills.maxStamina) + r.stamina
                    );
                    r.setRecovery(true);
                    System.out.println("Runner: " + r.getRunnerId() + " | " +
                                    "Run: " + r.getRanStatus() + " | " +
                                    "Stamina: " + r.stamina + " | " +
                                    "Stamina Loss: " + r.skills.staminaLossRate + " | " +
                                    "Recovered: " + (r.recovered ? "yes" : "no") + " | " +
                                    "Running: " + (r.start ? "on" : "off"));
                    }
                else {
                    if (r.recovered){
                        r.setRecovery(false);
                    }
                    System.out.println("Runner: " + r.getRunnerId() + " | " +
                                    "Run: " + r.getRanStatus() + " | " +
                                    "Stamina: " + r.stamina + " | " +
                                    "Stamina Loss: " + r.skills.staminaLossRate + " | " +
                                    "Recovered: " + (r.recovered ? "yes" : "no") + " | " +
                                    "Running: " + (r.start ? "on" : "off"));
                }
            }

            try {
                Thread.sleep(1000); // Define o intervalo de atualização (em milissegundos)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.print("\033[H\033[2J"); // Limpa a tela
            System.out.flush();
        }
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
    int maxStamina;

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
        this.maxStamina = qty;
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

class Runner implements Runnable{
    Random random = new Random();
    int id = random.nextInt(100_000);
    float miles;
    float run;
    boolean start = false;
    boolean recovered = false;
    Skills skills;
    float stamina;
    int runnerSkillFunc;

    public Runner(float miles){
        this.miles = miles;
    }

    public int getRunnerId(){
        return this.id;
    }

    public float getRanStatus(){
        return this.run;
    }

    public void setRanStatus(float run){
        this.run = run;
    }

    public void setRunnerSkillStd(int skill){
        this.runnerSkillFunc = skill;
    }

    public void setSkills(Skills skills){
        this.skills = skills;
    }

    public void setStart(boolean start){
        this.start = start;
        this.stamina = (float) this.skills.staminaAbs;
    }

    public void setRecovery(boolean recovered){
        this.recovered = true;
    }

    public void setStamina(float stamina){
        this.stamina = stamina;
    }

    @Override
    public void run(){
        this.setRanStatus(0f);
        float ran = 0f;
        int countSecs = 0;
        while(this.start){
            if (this.getRanStatus() <= this.miles & this.stamina > 0.1f){
                float stepMilesByHour = this.skills.maxSpeed * 
                    this.skills.staminaAbs * (this.skills.staminaPercentage - 
                        (this.skills.staminaPercentage * this.skills.staminaLossRate)) / 
                            this.skills.staminaAbs;
                
                float stepMilesBySec = stepMilesByHour / 3600;
                ran += stepMilesBySec;
                this.setRanStatus(ran);
                this.setStamina((this.stamina - (this.stamina * this.skills.staminaLossRate)));
                countSecs++;
                System.out.print("\rRunner ID: " + this.id + " | " +
                                        "Ran: " + this.getRanStatus() + " | " +
                                        "Stamina: " + this.stamina + " | " +
                                        "Time: " + countSecs + " | " +
                                        "Started: " + (this.start ? "on" : "off") + " | ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                if (this.getRanStatus() > this.miles){
                    this.setStart(false);
                    System.out.print("\rRunner ID: " + this.id + " | " +
                                        "Ran: " + this.getRanStatus() + " | " +
                                        "Stamina: " + this.stamina + " | " +
                                        "Time: " + countSecs + " | " +
                                        "Started: " + (this.start ? "on" : "off") + " | " +
                                        "WINNER!!!");
                } else if (this.stamina <= 0.1f){
                    this.setStart(false);
                    System.out.print("\rRunner ID: " + this.id + " | " +
                                        "Ran: " + this.getRanStatus() + " | " +
                                        "Stamina: " + this.stamina + " | " +
                                        "Time: " + countSecs + " | " +
                                        "Started: " + (this.start ? "on" : "off") + " | " +
                                        "DIED!!!");
                    break;
                }
            }

        }
    }

    public String showRunner(){
        return "\rRunner ID: " + this.id + " | " +
                    "Ran: " + this.getRanStatus() + " | " +
                    "Stamina: " + this.stamina + " | " +
                    "Started: " + (this.start ? "on" : "off");
    }
}

