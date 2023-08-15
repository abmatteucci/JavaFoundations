package JFT4;
/*
The area of a room is calculated by multiplying length by width.
Compute and display the cost of carpeting a room in square yards.
Create variables to store the length (25.00) and width (42.00) of a room in square feet.
The program needs to calculate the total cost of carpeting per square yard in Euro and cent.
The cost of carpeting per square yard is €37.99.
Note: There are nine square feet in one square yard.
Compute and display the cost of carpeting the room in square yards.
Save the program as JFT4Ex7
*/

import java.util.ArrayList;
import org.json.JSONObject;
// import org.json.JSONArray;

public class JFT4Ex7 {
    public static void main(String[] args){
        
        String repeated = new String(new char[20]).replace("\0", "*");
        Product prod = new Product("Carpet", 37.99f, "Yard");
        Mesure medida = new Mesure("Feet", "Yard", 0.33333f);
        Mesure metroToYard = new Mesure("Metro", "Yard", 1.09361f);
        System.out.println(); 
        // Cria lista de Mesures
        ArrayList<Mesure> medidas = new ArrayList<>();
        medidas.add(medida);
        medidas.add(metroToYard);
        // Criando e instanciando o Square
        Square square = new Square(9f, 12f, "Metro");
        // Instanciando e iniciando o Conversor
        Conversor conversor = new Conversor(medidas, "Metro", "Yard");
        Square new_Square = conversor.convert(square, "Yard");
        System.out.println("JFT4Ex7: Compute and display the cost of carpeting a room in square yards.");
        System.out.println(repeated + repeated + repeated);
        System.out.println(repeated + prod.name + " Cost" + repeated);
        System.out.println(repeated + repeated + repeated);
        System.out.println("Square " + square.uMesureStd + ": " + square.areaFlat);
        System.out.println("Square Yard: " + new_Square.areaFlat);
        System.out.println("Cost: \u20AC" + new_Square.areaFlat * prod.cost);
    }
}

class Product{
    String name;
    float cost;
    String mesureUnity;
    JSONObject obj;

    public Product(String name, float cost, String mesureUnity){
        this.name = name;
        this.cost = cost;
        this.mesureUnity = mesureUnity;
        JSONObject prod = new JSONObject();
        prod.put("name", name);
        prod.put("cost", cost);
        prod.put("mesure_unity", mesureUnity);
        this.obj = prod;
    }
}

class Mesure{
    JSONObject mesure;
    String from;
    String to;
    float ratio;

    public Mesure(String fromStd, String toStd, float ratio){
        JSONObject objStdMesure = new JSONObject();
        objStdMesure.put("from", fromStd);
        objStdMesure.put("to", toStd);
        objStdMesure.put("ratio", ratio);
        this.mesure = objStdMesure;
        this.from = fromStd;
        this.to = toStd;
        this.ratio = ratio;
    }
}

class Conversor{
    ArrayList<Mesure> mesures;
    String fromStd;
    String toStd;
    Square toConvert;
    Square converted;

    public Conversor(ArrayList<Mesure> mesures, String fromStd, String toStd){
        
        this.mesures = mesures;
        this.fromStd = fromStd;
        this.toStd = toStd;
    }

    public Square convert(Square square, String toStd){
        this.toConvert = square;
        for (Mesure mesure : mesures){
            if (mesure.from == square.uMesureStd && mesure.to == toStd){
                Square convertedSquare = new Square(square.width * mesure.ratio, square.length * mesure.ratio, toStd);
                
                return convertedSquare;
            }

        }
        return square;
    }
}

class Square{
    float width;
    float length;
    String uMesureStd;
    float areaFlat;
    JSONObject area;

    public Square(float width, float length, String uMesureStd){
        JSONObject square = new JSONObject();
        this.width = width;
        this.length = length;
        this.uMesureStd = uMesureStd;
        this.areaFlat = (width * length);
        square.put("width", width);
        square.put("length", length);
        square.put("uMesureStd", uMesureStd);
        square.put("area", (width * length));
        this.area = square;
    }

    public float getWidth(){
        return this.width;
    }

    public float getLength(){
        return this.length;
    }

    public String getUMesureStd(){
        return this.uMesureStd;
    }

    public float getAreaFlat(){
        return this.areaFlat;
    }

    public JSONObject getArea(){
        return this.area;
    }
}

