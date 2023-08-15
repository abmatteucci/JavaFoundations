package JFT6;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.lang.Thread;


/*
Write a Java program to model an air conditioning system. Assume that the current
temperature is 14.19 degrees centigrade. Store this information in a variable. Test the value
stored in the variable. Display an appropriate message to the user, as per the table below.
Test your program with different temperatures.
20+ tropical
10 to 19 warm
0 to 9 moderate
-1 to -4 cold
-5 or below arctic
• Save the program as JFT6Ex9.java
 */

public class JFT6Ex9 {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        String repeated = new String(new char[20]).replace("\0", "*");
        String repeated_blank = new String(new char[10]).replace("\0", " ");
        
        AirConditioning acs1 = new AirConditioning("ACS1", 1);
        acs1.setTempFunction(4);

        // Inicie a thread do sistema de ar condicionado
        Thread thread1 = new Thread(acs1);
        thread1.start();

        Boolean active = true;

        while (active){
            
            System.out.println(repeated + "Air Conditioning System" + repeated);
            System.out.println(repeated + repeated + repeated);
            System.out.println();
            System.out.println("Resumo: Temperatura atual: " + acs1.actualTemperature);
            System.out.println();
            System.out.println("Insira o comando: ");
            System.out.println("Para atualizar a temperatura ambiente atual 'A'," + 
                            "\npara Iniciar o sistema 'I' e" + 
                            "\npara setting-up a temperaruta target 'W'," +
                            "\npara ver o log 'L' e" + 
                            "\npara sair digite 'S'.");
            System.out.println();
            String inputStr = scanner.next();
            System.out.println();
            scanner.nextLine();
            
            
            switch (inputStr) {
                case "A":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Nova Temperatura");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    System.out.println("Temperatura atual: "+ acs1.actualTemperature);
                    System.out.println();
                    System.out.print("Insira o novo valor de temperatura: ");
                    float newTemp = scanner.nextFloat();
                    acs1.setActualTemperature(10.0f + newTemp);                    
                    break;
                case "I":
                    System.out.println("Status Power: " + (acs1.power ? "on" : "off"));
                    if (!acs1.power){
                        acs1.setPower(true);
                    }
                    System.out.println("New Status: " + (acs1.power ? "on" : "off"));
                    break;
                case "W":
                    System.out.println("A função de temperatura atual: " + acs1.temperatureFunctionName);
                    System.out.println("Selecione entre as funções: " +
                        "\n0. Arctic;" +
                        "\n1. Cold;" + 
                        "\n2. Moderate;" +
                        "\n3. Warm;" +
                        "\n4. Tropical.");
                    System.out.println();
                    int option = scanner.nextInt();
                    acs1.setTempFunction(option);
                    System.out.println("Função de temperatura selecionada: " + acs1.temperatureFunctionName);

                case "L":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Air Conditioning System Log");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    //resumeCourse(courses);
                    break;
                case "S":
                    active = false;
                    System.out.println("Exiting Air Conditioning System.");
                    System.out.println();
                    break;

                default:
                    break;
            
            }
        
        }
        scanner.close();
    }

    private static Date parseStringToDate(String date){
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date data = formatoData.parse(date);
            return data;
        } catch (ParseException e) {
            System.out.println("Erro ao converter a data. Verifique o formato da String (dd/MM/yyyy).");
            return null;
        }

    }

    private static String generateConcept(float gradeValue){
        if (gradeValue >= 0.85f){
            return (String) "A"; 
        } else if (gradeValue >= 0.7f & gradeValue <= 0.84f){
            return (String) "B";
        } else if (gradeValue >= 0.55f & gradeValue <= 0.69f){
            return (String) "C";
        } else if(gradeValue >= 0.4f & gradeValue <= 0.54f){
            return (String) "D";
        } else if(gradeValue >= 0.25f & gradeValue <= 0.39f){
            return (String) "E";
        } else if(gradeValue >= 0.1f & gradeValue <= 0.24f){
            return (String) "F";
        } else {
            return (String) "No grade";
        }
    }
}

class AirConditioning implements Runnable{
    Random random = new Random();
    int id = random.nextInt(100_000);
    String name;
    float actualTemperature;
    int temperatureFunctionId;
    String temperatureFunctionName;
    float maxTemp;
    float minTemp;
    boolean power = false;
    int refreshRateInMiliseconds = 2000;
    ArrayList<Log> logsHistory = new ArrayList<>();

    public AirConditioning(String name, int funcId){
        this.name = name;
        this.temperatureFunctionId = funcId;
    }

    @Override
    public void run(){
        while (true){
            this.setLog();
            System.out.print("\rTemperature: " + this.actualTemperature);
            if (this.power){
                if (this.minTemp < this.actualTemperature & this.maxTemp > this.actualTemperature){
                    System.out.print("\rFunction selected: " + this.temperatureFunctionName + " | " +
                                    "Actual Temperature: " + this.actualTemperature + " | " +
                                    "Status: On target" + " | " +
                                    "Power: " + (this.power ? "on" : "off") + " | ");
                } else if (this.minTemp > this.actualTemperature){
                    while (this.actualTemperature < this.minTemp){
                        float increaseTemp = random.nextFloat();
                        this.actualTemperature += increaseTemp;
                        System.out.print("\rFunction selected: " + this.temperatureFunctionName + " | " +
                                        "Actual Temperature: " + this.actualTemperature + " | " +
                                        "Status: Increasing..." + " | " +
                                        "Power: " + (this.power ? "on" : "off") + " | ");
                        try {
                            Thread.sleep(refreshRateInMiliseconds);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if (this.actualTemperature > this.maxTemp){
                    while (this.actualTemperature > this.maxTemp){
                        float decreaseTemp = random.nextFloat();
                        this.actualTemperature -= decreaseTemp;
                        System.out.print("\rFunction selected: " + this.temperatureFunctionName + " | " + 
                                        "Actual Temperature: " + this.actualTemperature + " | " +
                                        "Status: Decreasing..." + " | " +
                                        "Power: " + (this.power ? "on" : "off") + " | ");
                        try {
                            Thread.sleep(refreshRateInMiliseconds);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

            try {
                Thread.sleep(refreshRateInMiliseconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void setActualTemperature(float temp){
        this.actualTemperature = temp;
    }

    public void setTempFunction(int func){
        this.temperatureFunctionId = func;
        switch (func){
            case 0:
                this.temperatureFunctionName = "arctic";
                this.minTemp = -20f;
                this.maxTemp = -5f;
                break;
            case 1:
                this.temperatureFunctionName = "cold";
                this.minTemp = -4f;
                this.maxTemp = -1f;
                break;
            case 2:
                this.temperatureFunctionName = "moderate";
                this.minTemp = 0f;
                this.maxTemp = 9f;
                break;
            case 3:
                this.temperatureFunctionName = "warm";
                this.minTemp = 10f;
                this.maxTemp = 19f;
                break;
            case 4:
                this.temperatureFunctionName = "tropical";
                this.minTemp = 20f;
                this.maxTemp = 29f;
                break;
            default:
                this.temperatureFunctionName = "warm";
                this.minTemp = 10f;
                this.maxTemp = 19f;
                break;
        }
    }

    public void setLog(){
        Log log = new Log(this.id, this.name, this.actualTemperature, this.temperatureFunctionId, this.refreshRateInMiliseconds);
        this.logsHistory.add(log);
    }

    public void setPower(boolean power){
        this.power = power;
    }
}

class Log{
    Random random = new Random();
    LocalDate date;
    int id = random.nextInt(100_000);
    int systemId;
    String systemName;
    float systemDataSensor;
    int systemTargetFuncId;
    int refreshRateInMiliseconds;

    public Log(int systemId, String systemName, float sensor, int targetFuncId, int refreshRate){
        LocalDate dataAtual = LocalDate.now();
        this.date = dataAtual;
        this.systemId = systemId;
        this.systemName = systemName;
        this.systemDataSensor = sensor;
        this.systemTargetFuncId = targetFuncId;
        this.refreshRateInMiliseconds = refreshRate;
    }
    
}