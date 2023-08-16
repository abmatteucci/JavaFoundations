package JFT6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


/*
Create a Java program which determines the number of fish in a tank. Create the main method and
within it, a variable named noOfFishInTank. The variable should be of type int. Store the value 3 in
the variable.
Use a switch statement to determine the value stored in the variable and display an appropriate
message in the console.
No. of Fish Message to Display
No fish There are no fish in the tank.
One fish There is one fish in the tank.
Two fish There are two fishes in the tank.
Three fish There are three fishes in the tank.
Any other number of fish An indeterminate number of fish are in the tank.
Save the program as JFT6Ex11.java
 */

public class JFT6Ex11{
    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        String repeated = new String(new char[20]).replace("\0", "*");
        String repeated_blank = new String(new char[10]).replace("\0", " ");
        
        // Criando um tanque.
        ArrayList<Fish> tanque = new ArrayList<>();
        Boolean active = true;

        while (active){
            
            System.out.println(repeated + "FishTank" + repeated);
            System.out.println(repeated + repeated + repeated);
            System.out.println();
            
            System.out.println("Insira o comando: ");
            System.out.println("Para inserir peixes no tanque, 'I'" + 
                            "\npara Resumir o estado atual do Tanque 'T' e" + 
                            "\npara sair digite 'S'.");
            System.out.println();
            String inputStr = scanner.next();
            System.out.println();
            scanner.nextLine();
            
            
            switch (inputStr) {
                case "I":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Inserir peixes no tanque:");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    System.out.print("Digite a quantidade de peixes que serão inseridos no tanque (digite números inteiros): ");
                    int qty = scanner.nextInt();
                    tanque = insertFish(tanque, qty);
                    System.out.println("Foram inseridos " + qty + " peixes com sucesso!");
                    break;
                case "T":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Status atual do Tanque:");
                    System.out.println(repeated + repeated + repeated);
                    System.out.println();
                    System.out.println("Quantidade atual de peixes no tanque: " + tanque.size());
                    System.out.println("Quantidade de peixes (resolução do exercício): " + getQtyMessage(tanque.size()));
                    System.out.println();
                    break;
                case "S":
                    active = false;
                    System.out.println("Saindo do programa FishTank.");
                    System.out.println();
                    break;

                default:
                    break;
            
            }
        
        }
        scanner.close();
    }

    private static ArrayList<Fish> insertFish(ArrayList<Fish> tanque, int qty){
        for (int i = 0; i < qty; i++){
            Random rd = new Random();
            Fish fish = new Fish(rd.nextFloat());
            tanque.add(fish);
        }
        return tanque;
    }

    private static String getQtyMessage(int qty){
        switch (qty){
            case 0:
                return "There are no fish in the tank.";
            case 1:
                return "There is one fish in the tank.";
            case 2:
                return "There are two fishes in the tank.";
            case 3:
                return "There are three fishes in the tank.";
            default:
                return "An indeterminate number of fish are in the tank.";
        }
    }
}

class Fish{
    Random random = new Random();
    int id = random.nextInt(100_000);
    float weight;

    public Fish(float weight){
        this.weight = weight;
    }

    public int getFishId(){
        return this.id;
    }

    public float getFishWeight(){
        return this.weight;
    }
}

