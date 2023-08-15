package JFT6;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/*
Write a Java program to determine if a salesperson is entitled to a commission bonus or not.
 A salesperson is entitled to a bonus, if he/she has sold 1,000 or more products, has 20 or
more years’ service and has accumulated sales for the year to date of €10,000 or over.
 Make use of variables as part of your solution and store sample values. Test your solution.
 Save the program as JFT6Ex7.java
 */

public class JFT6Ex7 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String repeated = new String(new char[20]).replace("\0", "*");
        String repeated_blank = new String(new char[10]).replace("\0", " ");
        // SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        // Date hd1 = formatoData.parse("07/08/2002");
        // Date hd2 = formatoData.parse("01/07/2003");
        Boolean active = true;
        SallesPerson p1 = new SallesPerson("Antonio", "Matteucci", parseStringToDate("07/08/2002"));
        SallesPerson p2 = new SallesPerson("Sarah", "Matteucci", parseStringToDate("01/08/2005"));
        ArrayList<SallesPerson> sellers = new ArrayList<>();
        sellers.add(p1);
        sellers.add(p2);

        ArrayList<Product> products = generateProducts(sellers, 1000);
        
        
        while (active){
            
            System.out.println(repeated + "Bem-vindo ao nosso Sistema de Funcionários!" + repeated);
            System.out.println(repeated + "Cadastro dos Vendedores " + repeated);
            System.out.println();
            System.out.println("Resumo: Quantidade de produtos vendidos até agora: " + products.size());
            System.out.println("Insira o comando: ");
            System.out.println("Para inserir vendedor digite 'I',\npara editar 'E', \npara excluir 'D', \npara listar vendedores 'L', \npara listar vendedores bonificados 'B' e \npara sair digite 'S'.");
            
            String inputStr = scanner.next();
            System.out.println();
            scanner.nextLine();
            
            
            switch (inputStr) {
                case "I":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + "Inserir vendedor");
                    System.out.println(repeated + repeated + repeated);
                    System.out.print("Digite o primeiro nome do vendedor: ");
                    String nome = scanner.next();
                    scanner.nextLine();
                    System.out.print("Digite o sobrenome do vendedor: ");
                    String surname = scanner.next();
                    scanner.nextLine();
                    System.out.print("Insira a data de contratação do vendedor: ");
                    String hireDate = scanner.next();
                    scanner.nextLine();
                    

                    SallesPerson newSeller = new SallesPerson(nome, surname, parseStringToDate(hireDate));
                    sellers.add(newSeller);
                    System.out.println("Vendedor inserido com sucesso! \n" +
                        "Bem-vindo ao nosso Time, " + newSeller.firstName + "!");
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
                    System.out.println(repeated_blank + repeated_blank + "Lista de vendedores");
                    System.out.println(repeated + repeated + repeated);
                    for (SallesPerson sallePerson : sellers){
                        String fullName = sallePerson.firstName + " " + sallePerson.lastName;
                        System.out.println(fullName + repeated_blank + 
                        "Qty. sold: " + getTotalSoldProducts(sallePerson, products) + repeated_blank +
                        "Total sold value: " + getTotalSoldValue(sallePerson, products) + repeated_blank +
                        "Years of service: " + getYearsOfService(sallePerson));
                    }
                    System.out.println();
                    break;
                case "B":
                    System.out.println(repeated + repeated + repeated);
                    System.out.println(repeated_blank + repeated_blank + "Lista de vendedores bonificados");
                    System.out.println(repeated + repeated + repeated);
                    for (SallesPerson sallePerson : sellers){
                        int sumProducts = getTotalSoldProducts(sallePerson, products);
                        float totalSold = getTotalSoldValue(sallePerson, products);
                        long years = getYearsOfService(sallePerson);
                        if (sumProducts >= 1000 & totalSold >= 10_000 & years >= 20){
                            String fullName = sallePerson.firstName + " " + sallePerson.lastName;
                            System.out.println(fullName + repeated_blank + 
                            "Qty. sold: " + sumProducts + repeated_blank +
                            "Total sold value: " + totalSold + repeated_blank +
                            "Years of service: " + years);
                        }
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

    private static String generateSKU(int inteiro){
        String sku = "SKU" + inteiro;
        return sku;
    }

    private static String generateProductName(int i){
        switch (i){
            case 1:
                return "smartphone";
            case 2:
                return "notebook";
            case 3:
                return "console";
            case 4:
                return "charger";
            case 5:
                return "nobreak";
            case 6:
                return "monitor";
            case 7:
                return "motherboard";
            default:
                return "videocard";
        }
    }

    private static float generatePrice(int inteiro){
        Random random = new Random();
        return inteiro + random.nextFloat();
    }

    private static ArrayList<Product> generateProducts(ArrayList<SallesPerson> sellers, int quantity){
        Random random = new Random();
        ArrayList<Product> productsList = new ArrayList<>();
        for (SallesPerson seller : sellers){
            for (int j=0; j <= quantity; j++){
                Product prod = new Product(generateSKU(random.nextInt(100_000)), 
                                        generateProductName(random.nextInt(7)),
                                        generatePrice(random.nextInt(250)),
                                        seller.id);
                productsList.add(prod);
            }
        }
        return productsList;
    }

    private static int getTotalSoldProducts(SallesPerson seller, ArrayList<Product> products){
        int conta = 0;
        for (Product product : products){
            if (product.pSellerId == seller.id){
                conta++;
            }
        }
        return conta;
    }

    private static float getTotalSoldValue(SallesPerson seller, ArrayList<Product> products){
        float valor = 0;
        for (Product product : products){
            if (product.pSellerId == seller.id){
                valor += product.pPrice;
            }
        }
        return (float) valor;
    }

    private static long getYearsOfService(SallesPerson seller){
        Date dataAtual = new Date();
        long diffMili = dataAtual.getTime() - seller.hireDate.getTime();
        // Converta a diferença em milissegundos para anos
        long anos = diffMili / (1000L * 60L * 60L * 24L * 365L);
        return (long) anos;
    }
}

class SallesPerson{
    String firstName;
    String lastName;
    Date hireDate;
    int id;

    public SallesPerson(String firstName, String lastName, Date hireDate){
        Random random = new Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.hireDate = hireDate;
        this.id = random.nextInt(100_000);
    }

    public String getSallesPersonName(){
        return this.firstName;
    }

    public int getSallePersonId(){
        return this.id;
    }

    public Date getHireDate(){
        return this.hireDate;
    }
}

class Product{

    String sku;
    String pName;
    float pPrice;
    int pSellerId;

    public Product(String sku, String pName, float price, int sellerId){
        this.sku = sku;
        this.pName = pName;
        this.pPrice = price;
        this.pSellerId = sellerId;
    }

}
