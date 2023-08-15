package JFT2;
/*
    Write a Java program, which acts as a basic currency converter.
    Display the following message:
    Welcome to the FX Currency Converter.
    Create the following multi-line comment:
    Currency Conversion Rates:
    1.00 EUR = 0.697443 GBP
    1.00 EUR = 1.08901 USD
    1.00 EUR = 135.090 JPY
    Convert 100 Euro into each of the stated currencies and display the results.
*/

import java.util.ArrayList;
import org.json.JSONObject;
import org.json.JSONArray;

public class JFT2Ex6 {
    public static void main(String[] args){
        
        String json_str = "[{\"currencyName\":\"GBL\",\"priceInEURO\":0.697443}, {\"currencyName\":\"USD\",\"priceInEURO\":1.08901}, {\"currencyName\":\"JPY\",\"priceInEURO\":135.090}]";
        JSONArray currenciesJson = new JSONArray(json_str);
        
        ArrayList<Currency> currencies = new ArrayList<>();
        for (int i = 0; i < currenciesJson.length(); i++){

            JSONObject jsonObj = currenciesJson.getJSONObject(i);
            Currency currency = new Currency(jsonObj.getDouble("priceInEURO"), jsonObj.get("currencyName").toString());
            // student.setAge(studentAges[i]);
            currencies.add(currency);
        }

        System.out.println("Welcome to the FX Currency Converter.");
        float conversion = 0;
        float quantity = 100;
        for (int i = 0; i < currencies.size(); i++){
            Currency currency = currencies.get(i);
            conversion = (float) currency.convertCurrency(quantity);
            System.out.println("O valor de "+ quantity +" " + currency.stdCurrency + " convertido em " + currency.currencyName + " é: " + conversion);
            // ageSum += (int) student.getAge();
        }
        /*
        int ageAverage = (int) (ageSum / students.size()); 
        System.out.println("The average age of all students is: " + ageAverage);
        */
    }
}

class Currency{
    public double priceInEURO;
    public String currencyName;
    public String stdCurrency = "EURO";

    public Currency(double price, String currency){
        this.priceInEURO = price;
        this.currencyName = currency;
    }

    public void setCurrencyName(String currencyName){
        this.currencyName = currencyName;
    }

    public String getCurrencyName(){
        return this.currencyName;
    }

    public void setPrice(double price){
        this.priceInEURO = price;
    }

    public double getPrice(){
        return this.priceInEURO;
    }

    public double convertCurrency(double quantity){
        return priceInEURO * quantity;
    }
}
