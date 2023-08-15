package JFT6;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


/*
This is similar to the previous exercise.
 Assume the amount to withdraw is 20.
 Assume the existing balance is 180.
 Determine if the withdrawal request can be made.
 Display one of two messages.
▪ Insufficient funds
▪ Withdrawal processed
 Use the conditional ternary operator (?:) to solve the problem.
 The value returned by the conditional ternary operator should be stored in a variable of type
String.
 Output the value of the String to the console.
 Save the program as JFT6Ex5.java
 */

public class JFT6Ex5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        User u1 = new User("Antonio", "Matteucci", "abmatteucci", "123456");
        User u2 = new User("Sarah", "Matteucci", "sarah.quilice", "123456");
        ArrayList<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);

        ArrayList<MyAccount> accounts = new ArrayList<>();

        for (User user : users){
            MyAccount account = new MyAccount(user);
            account.setAccBalance(account.id, 180);
            accounts.add(account);
        }

        while (true){

            String repeated = new String(new char[20]).replace("\0", "*");
            
            System.out.println(repeated + "Bem-vindo ao nosso ATM" + repeated);
            System.out.println();
            System.out.println("Digite 'sair' para sair do programa.");
            System.out.print("Insira seu nome de usuário (username): ");
            
            String inputStr = scanner.next();
            
            if (inputStr.equals("sair")){
                System.out.println("Obrigado por usar nosso ATM.");
                break;
            } else {

                // Buscando a conta do usuário informado.
                MyAccount acc = getUserAcc(accounts, getUser(users, inputStr));

                // Setting up o saldo da conta para 180.
                // acc.setAccBalance(acc.id, 180);
                
                

                User user = getUserByAccId(users, acc.id);

                System.out.println("Bem-vindo " + user.userFirstName + "!");
                System.out.println("User Account ID: " + acc.id);
                System.out.println("User Account Balance: " + acc.accBalance);
                System.out.println(repeated + repeated);
                // Pedindo ao usuário o amount a ser retirado.
                System.out.print("Insira o valor a ser retirado da conta: ");
                float retirada = scanner.nextFloat();

                // Verifica se o valor está disponível para retirada.
                System.out.println("O valor solicitado foi: " + retirada);

                String message = (acc.verifySufficientBalance(retirada)) ? "O valor de " + retirada + " está disponível para retirada." : "O valor excede o limite disponível para saque.";
                if (acc.verifySufficientBalance(retirada)){
                    System.out.println(message);
                    System.out.println("Deseja realizar a operação de saque?");
                    System.out.println("Digite 'S' para realizar a operação ou 'N' para cancelar. ");
                    String resposta = scanner.next();
                    if (resposta.equals("S")){
                        acc.setAccBalance(acc.id, acc.accBalance - retirada);
                        System.out.println(repeated + "Saque" + repeated);
                        System.out.println("Saque efetuado com sucesso!");
                        System.out.println("Seu novo saldo é de " + acc.accBalance);
                    } else if (resposta.equals("N")){
                        System.out.println("Você saiu da operação.");
                    }
                } else {
                    System.out.println(message);
                }
                
                
                
            }
            
        }
        scanner.close();
    }

    private static User getUser(ArrayList<User> users, String username){
        for (User user : users){
            if (user.username.equals(username)){
                return user;
            }
        }
        return null;
    }

    private static MyAccount getUserAcc(ArrayList<MyAccount> accounts, User user){
        for (MyAccount acc : accounts){
            if (acc.id ==user.id){
                return acc;
            }
        }
        return null;
    }

    private static User getUserByAccId(ArrayList<User> users, int id){
        for (User user : users){
            if (user.id == id){
                return user;
            }
        }
        return null;
    }
}

class User{
    String userFirstName;
    String userLastName;
    String username;
    String password;
    int id;

    public User(String userFirstName, String userLastName, String username, String password){
        Random random = new Random();
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.username = username;
        this.password = password;
        this.id = random.nextInt(100_000);
    }

    public String getUsername(){
        return this.username;
    }
}

class MyAccount{
    int id;
    float accBalance;
    User user;

    public MyAccount(User user){
        this.id = user.id;
        this.user = user;
    }

    public void setAccBalance(int id, float accBalance){
        if (this.id == id) {
            this.accBalance = accBalance;
        }
    }

    public boolean verifySufficientBalance(float retirada){
        if (this.accBalance >= retirada){
            return true;
        }
        return false;
    }
}