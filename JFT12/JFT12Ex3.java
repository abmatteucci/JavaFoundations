package JFT12;

public class JFT12Ex3 {

    public static void main(String[] args) {
        String s1 = new String("dinghy");
        String s2 = "dinghy";
        String s3 = s2;
        s1 = s1.concat("rubber");
        s2.concat(s1);
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // false
        System.out.println(s2 == s3); // true
        System.out.println(s2.equals(s3)); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s3)); // false
        System.out.println(s1 + " " + s2); // "dinghyrubber dinghy"
    }
    
}
