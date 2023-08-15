package JFT6;

import java.util.Calendar;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;


/*
Create a variable named, dayOfWeek, in the main method. The variable should be of type, String.
Assign the value “Monday” to the variable. Use a switch statement to test the value stored in the
variable and display it in the console.
Save the program as JFT6Ex10.java
 */

public class JFT6Ex10 {
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        String repeated = new String(new char[20]).replace("\0", "*");
        String repeated_blank = new String(new char[10]).replace("\0", " ");
        
        Boolean active = true;

        while (active){
            
            System.out.println(repeated + "WeeklyDay" + repeated);
            System.out.println(repeated + repeated + repeated);
            System.out.println();
            
            System.out.println("Insira o comando: ");
            System.out.println("Para imprimir o dia da semana de hoje 'T'," + 
                            "\npara Retornar o dia da semana de uma data espcífica 'I' e" + 
                            "\npara sair digite 'S'.");
            System.out.println();
            String inputStr = scanner.next();
            System.out.println();
            scanner.nextLine();
            
            
            switch (inputStr) {
                case "T":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Que Dia da semana é hoje?");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    LocalDate today = LocalDate.now();
                    //System.out.println("Hoje é: " + today);
                    String dateBuilded = today.getDayOfMonth() + "/" + today.getMonthValue() + "/" + today.getYear();
                    System.out.println("Hoje é: " + dateBuilded);
                    System.out.println("O dia da semana é: " + getDayOfWeek(parseStringToDate(dateBuilded)));
                    System.out.println();
                    break;
                case "I":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Dia da semana de uma data específica");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    System.out.println("Insira a data no seguinte formato: 'dd/MM/yyyy'.");
                    String userInput = scanner.next();
                    Date inputData = parseStringToDate(userInput);
                    System.out.println("Dia da semana: " + getDayOfWeek(inputData));
                    System.out.println();
                    break;
                case "S":
                    active = false;
                    System.out.println("Saindo do programa Dia da semana.");
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

    private static String getDayOfWeek(Date data){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
        /*

        // 'Pythonic solutions.. ;)'
        String[] daysNames = {
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        };
        
        return daysNames[dayWeek - 1];
        */
        return getDayOfWeekSwitch(dayWeek);
    }

    private static String getDayOfWeekSwitch(int dayOfWeekNum){
        switch (dayOfWeekNum){
            case 1: 
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
                return "Friday";
            case 7:
                return "Saturday";
        }
        return null;
    }
}

