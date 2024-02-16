package JFT10;

public class quizz10 {
    public static void main(String[] args) {
    
        long a = 10L;
   long b = 20L;
  System.out.println(Math.max(a,b));
    }
}

class Animal{

    private static int noOfAnimals;
  
     public static void updateNoOfAnimals(){
      Animal.noOfAnimals++;
     }
  
    public static int getNoOfAnimals(){
     return noOfAnimals;
    }
  
}// class