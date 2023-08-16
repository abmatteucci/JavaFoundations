package JFT6;

import java.util.Scanner;
import java.util.Random;


/*
Create a Java program which determines a person’s marital status. Create the main method and
within it, a variable named status. The variable should be of type char. Store the value ‘D’ in the
variable. Use a switch statement to determine marital status. Display an appropriate message. For
example, if marital status is single, display the message "Status: Single". The categories are ‘S’
(Single), ‘D’ (Divorced), ‘M’ (Married), ‘W’ (Widowed). If there is no match, the message, “Invalid
data”, should be displayed.
Save the program as JFT6Ex12.java
 */

public class JFT6Ex12{
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        String repeated = new String(new char[20]).replace("\0", "*");
        String repeated_blank = new String(new char[10]).replace("\0", " ");
        
        // Criando uma Pessoa
        Person p1 = new Person('D');
        Boolean active = true;

        while (active){
            
            System.out.println(repeated + "Marital Status" + repeated);
            System.out.println(repeated + repeated + repeated);
            System.out.println();
            
            System.out.println("Insira o comando: ");
            System.out.println("Para editar o Marital Status, 'E'" + 
                            "\npara Resumir o status da pessoa 'R' e" + 
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

    private static String getMaritalStatusDescription(char status){
        switch (status){
            case 'S':
                return "Single.";
            case 'D':
                return "Divorced.";
            case 'M':
                return "Married.";
            case 'W':
                return "Widowed.";
            default:
                return "Invalid data.";
        }
    }
}

class Person{
    Random random = new Random();
    int id = random.nextInt(100_000);
    char maritalStatus;

    public Person(char maritalStatus){
        this.maritalStatus = maritalStatus;
    }

    public int getPersonId(){
        return this.id;
    }

    public char getPersonMaritalStatus(){
        return this.maritalStatus;
    }

    public void setPersonMaritalStatus(char status){
        this.maritalStatus = status;
    }
}

