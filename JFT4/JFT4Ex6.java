package JFT4;
/*
Given a sum of money (ex: €57), write a program to display the count of the following
currency denominations:
 €20 notes
 €10 notes
 €5 notes
 €1 coins
Use variables as part of your solution. Save the program as JFT4Ex6.java
*/

import java.util.ArrayList;
import org.json.JSONObject;
// import org.json.JSONArray;

public class JFT4Ex6 {
    public static void main(String[] args){
        
        String repeated = new String(new char[20]).replace("\0", "*");
        // Nota euro500 = new Nota("€500",500);
        // Nota euro200 = new Nota("€200",200);
        // Nota euro100 = new Nota("€100",100);
        Nota euro50 = new Nota("€50",50);
        Nota euro20 = new Nota("€20",20);
        Nota euro10 = new Nota("€10",10);
        Nota euro5 = new Nota("€5",5);
        // Nota euro2 = new Nota("€2",2);
        // Nota euroCoin2 = new Nota("€Coin2",2);
        Nota euroCoin1 = new Nota("€Coin1",1);
        // Nota euroCents50 = new Nota("€CoinCents50",0.5f);
        // Nota euroCents25 = new Nota("€CoinCents25",0.25f);
        // Nota euroCents10 = new Nota("€CoinCents10",0.10f);
        // Nota euroCents5 = new Nota("€CoinCents5",0.05f);
        // Nota euroCents1 = new Nota("€CoinCents1",0.01f);
        
        Nota[] pack = {euro50 ,euro20, euro10, euro5, euroCoin1};
        ArrayList<Nota> charge = new ArrayList<>();
        // Nota[] charge = new Nota[100];
        for (Nota nota : pack){
            for (int i=0; i < 10; i++ ){
                charge.add(nota);
            }
        }
        System.out.println(repeated + " " + charge.size());
        System.out.println(repeated + "charge.get(0).name: " + charge.get(0).name);
        ATM atm = new ATM(charge);
        System.out.println("JFT4Ex6: Program to display the count of currency denominations.");
        
        System.out.println(repeated + "Notas de \u20AC20 no ATM: " + atm.euro20Qty);
        ArrayList<Nota> dispenser = atm.saqueOptions(57);
        System.out.println(repeated + "Qtd. Notas no dispenser: " + dispenser.size());
        for (Nota paper : dispenser){
            System.out.println("Name: " + paper.name);
        }
        
    }
}

class Nota{
    String name;
    float noteValue;
    JSONObject note;

    public Nota(String name, float noteValue){
        this.name = name;
        this.noteValue = noteValue;
        JSONObject nota = new JSONObject();
        nota.put("name", name);
        nota.put("value", noteValue);
        this.note = nota;
    }
}

class ATM{
    
    int euro500Qty;
    int euro200Qty;
    int euro100Qty;
    int euro50Qty;
    int euro20Qty;
    int euro10Qty;
    int euro5Qty;
    int euro2Qty;
    int euroCoin2Qty;
    int euroCoin1Qty;
    int euroCents50Qty;
    int euroCents25Qty;
    int euroCents10Qty;
    int euroCents5Qty;
    int euroCents1Qty;
    ArrayList<Nota> notas;

    public ATM(ArrayList<Nota> notas){
        this.notas = notas;
        this.euro500Qty = this.getEuro500Qty();
        this.euro200Qty = this.getEuro200Qty();
        this.euro100Qty = this.getEuro10Qty();
        this.euro50Qty = this.getEuro50Qty();
        this.euro20Qty = this.getEuro20Qty();
        this.euro10Qty = this.getEuro10Qty();
        this.euro5Qty = this.getEuro5Qty();
        this.euro2Qty = this.getEuro2Qty();
        this.euroCoin2Qty = this.getEuroCoin2Qty();
        this.euroCoin1Qty = this.getEuroCoin1Qty();
        this.euroCents50Qty = this.getEuroCoinCents50Qty();
        this.euroCents25Qty = this.getEuroCoinCents25Qty();
        this.euroCents10Qty = this.getEuroCoinCents10Qty();
        this.euroCents5Qty = this.getEuroCoinCents5Qty();
        this.euroCents1Qty = this.getEuroCoinCents1Qty();
    }

    public int getEuro500Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€500"){
                    count++;
                }
            }
            return count;
        } 
        catch (NullPointerException e) {return count;}
    }

    public int getEuro200Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€200"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
        
    }

    public int getEuro100Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€100"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
        
    }

    public int getEuro50Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€50"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuro20Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€20"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuro10Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€10"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuro5Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€5"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuro2Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€2"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuroCoin2Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€Coin2"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuroCoin1Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€Coin1"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuroCoinCents50Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€CoinCents50"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuroCoinCents25Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€CoinCents25"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuroCoinCents10Qty(){
        int count = 0;
        try {
            for (Nota nota : notas){
                if (nota.name == "€CoinCents10"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuroCoinCents5Qty(){
        int count = 0;
        try{
            for (Nota nota : notas){
                if (nota.name == "€CoinCents5"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public int getEuroCoinCents1Qty(){
        int count = 0;
        try{
            for (Nota nota : notas){
                if (nota.name == "€CoinCents1"){
                    count += 1;
                }
            }
            return count;
        }
        catch (NullPointerException e) {return count;}
    }

    public ArrayList<Nota> saqueOptions(float valor){
        ArrayList<Nota> dispenser = new ArrayList<>(); 
        for (Nota nota : notas){
            if (nota.noteValue <= valor){
                dispenser.add(nota);
                valor -= nota.noteValue;
            }
        }
        return dispenser;
    }

}