package JFT6;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*
The bouncer at the local pub will only allow a patron to enter, if both of the following
conditions are met:
 The patron must be 18 years of age or older.
 The patron must be sober.
 Create a Java program, making use of an if-else statement to determine if a patron can enter
the pub.
 Make use of variables as part of your solution and store sample values. Test your solution.
 Save the program as JFT6Ex6.java
 */

public class JFT6Ex6 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String repeated = new String(new char[20]).replace("\0", "*");
        String repeated_blank = new String(new char[20]).replace("\0", " ");
        Boolean active = true;
        Patron p1 = new Patron("Antonio", "Matteucci", 18);
        Patron p2 = new Patron("Sarah", "Matteucci", 18);
        ArrayList<Patron> patrons = new ArrayList<>();
        patrons.add(p1);
        patrons.add(p2);

        
        while (active){
            
            System.out.println(repeated + "Bem-vindo ao nosso Pub!" + repeated);
            System.out.println(repeated + "Lista de cadastro de clientes " + repeated);
            System.out.println();
            System.out.println("Insira o comando: ");
            System.out.println("Para inserir cliente digite 'I',\npara editar 'E', \npara excluir 'D', \npara listar clientes 'L' e \npara sair digite 'S'.");
            
            String inputStr = scanner.next();
            System.out.println();
            scanner.nextLine();
            
            
            switch (inputStr) {
                case "I":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Inserir cliente");
                    System.out.println(repeated + repeated + repeated);
                    System.out.print("Digite o primeiro nome do cliente: ");
                    String nome = scanner.next();
                    scanner.nextLine();
                    System.out.print("Digite o sobrenome do cliente: ");
                    String surname = scanner.next();
                    scanner.nextLine();
                    System.out.print("Insira a idade do cliente: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("O cliente está sóbrio? ('s'/'n')");
                    String sober = scanner.next();
                    scanner.nextLine();

                    Patron newPatron = new Patron(nome, surname, age);
                    if (verifyAge(newPatron) & verifySober(sober)) {
                        patrons.add(newPatron);
                        System.out.println("Cliente inserido com sucesso! \n" +
                        "Bem-vindo ao nosso Pub! Obrigado pela preferência!");
                    } else {
                        System.out.println("O cliente não pode ser inserido na lista: \n" + 
                        "neste Pub só permitimos clientes maiores de 18 anos e " + 
                        "ele precisa estar sóbrio. Desculpe!");
                    }
                    break;
                case "E":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Editar cadastro");
                    System.out.println(repeated + repeated + repeated);
                    break;
                case "D":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Excluir cadastro");
                    System.out.println(repeated + repeated + repeated);
                    break;
                case "L":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Lista de clientes");
                    System.out.println(repeated + repeated + repeated);
                    for (Patron patron : patrons){
                        String fullName = patron.patronFirstName + " " + patron.patronLastName;
                        System.out.println(fullName);
                    }
                    System.out.println();
                    break;
                case "S":
                    active = false;
                    System.out.println("Obrigado pela preferência! Até breve.");
                    break;

                default:
                    break;
            
            }
        
        }
        scanner.close();
    }

    private static boolean verifyAge(Patron patron){
        return (patron.patronAge >= 18) ? true : false;
    }

    private static boolean verifySober(String sober){
        boolean sob;
        switch (sober){
            case "s":
                sob = true;
                break;
            case "n":
                sob = false;
                break;
            default:
                sob = true;
                break;
        }
        return sob;
    }
}

class Patron{
    String patronFirstName;
    String patronLastName;
    int patronAge;
    int id;

    public Patron(String userFirstName, String userLastName, int age){
        Random random = new Random();
        this.patronFirstName = userFirstName;
        this.patronLastName = userLastName;
        this.patronAge = age;
        this.id = random.nextInt(100_000);
    }

    public String getUsername(){
        return this.patronFirstName;
    }

    public int getPatronAge(){
        return this.patronAge;
    }
}

