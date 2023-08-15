package JFT4;
/*
    Write a Java program to calculate the VAT payable and total purchase price for a bottle of
whiskey.
The price before VAT is €14.50. The VAT rate is 23%.
Calculate and display the VAT and total price payable.
Use variables as part of your solution. Save the program as JFT4Ex2.java
*/


public class JFT4Ex2 {
    public static void main(String[] args){
        
        System.out.println("JFT4Ex2: Performming calculation of the VAT payable and total purchase price for a bottle of\n" + //
                "whiskey.");
        
        Product whiskeyBottle = new Product("Whiskey Bottle", 0.23f, 14.50f);
        System.out.println("The price before VAT is $" + whiskeyBottle.productPrice + 
        ". The VAT rate is " + (int) (whiskeyBottle.productVAT * 100) + "%.");
        System.out.println("Purchase Amount: " + whiskeyBottle.productPrice);
        System.out.println("VAT Playable: " + whiskeyBottle.calculateVATInCurrency());
        System.out.println("Total price: " + whiskeyBottle.calculatePriceWithVAT());
        
    }
}

class Product {
    String productName;
    float productVAT;
    float productPrice;

    public Product(String name, float vat, float price) {
        this.productName = name;
        this.productVAT = vat;
        this.productPrice = price;
    }

    public String getProductName(){
        return this.productName;
    }

    public float getProductVAT(){
        return this.productVAT;
    }

    public float getProductPrice(){
        return this.productPrice;
    }

    public float calculateVATInCurrency(){
        return (float) this.productPrice * this.productVAT;
    }

    public float calculatePriceWithVAT(){
        return (float) this.calculateVATInCurrency() + this.productPrice;
    }
}