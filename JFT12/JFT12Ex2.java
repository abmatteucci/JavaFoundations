package JFT12;

public class JFT12Ex2 {

    public static void main(String[] args) {
        
        String javaFoundations = new String("Java Foundations");
        String jFoundations = "Java Foundations";
        System.out.println(javaFoundations == jFoundations); // false
        System.out.println(javaFoundations.equals(jFoundations)); // true
        System.out.println(javaFoundations.compareTo(jFoundations)); // 0

    }
    
}
