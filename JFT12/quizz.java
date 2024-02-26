package JFT12;

public class quizz {

    public static void main(String[] args) {
        
//         String message = "Ship Ahoy";
//    char x = message.charAt(1);
//    System.out.println(x);

    // String message = "Ship Ahoy";
    // String message2 = new String("Ship Ahoy");
    // System.out.println(message.compareTo(message2));

    // String message = "Ship Ahoy";
    // String message2 = new String("Ships Ahoy");
    // System.out.println(message.compareTo(message2));

    // String message = "Ship Ahoy Mate!";
    // System.out.println(message.length());

    // String message = "Ship Cruisin' along in calm waters";
    // String message_Extract = message.substring(5);
    // System.out.println(message_Extract);

    // String message = "Ship Cruisin' along in calm waters";
    // String message_Extract = message.substring(5,13);
    // System.out.println(message_Extract);

//     String message = "Ship Ahoy";
//   String greeting = " matey!";
//   System.out.println(message.concat(greeting));

        // String message = "Ship Ahoy";
        // String message2 = "Ship Ahoy";
        // System.out.println(message == message2);

        // String message = "Ship Ahoy";
        // String message2 = new String("Ship Ahoy");
        // System.out.println(message.equals(message2));

//         String message = "Ship Ahoy Mate!";
//    System.out.println(message.equalsIgnoreCase("ship ahoy mate!"));

        // String message = "Ship Ahoy Mate!";
        // message.replace('o','a');
        // System.out.println(message);

        // System.out.println(new Human("Harry Kane",22).toString());

        // String message = "Ship Ahoy Mate!";
        // message = message.toUpperCase();
        // System.out.println(message);

        // String message = "          Ship Docked          ";
        // message.trim();
        // System.out.println(message);

        // System.out.printf("%d bottles of beer on the wall. " , 10);

        int noOfTicketsRemaining = 5;
    int noOfTicketsDesired = 12;
    String sellTicketMessage = "Sale made";
    String noTicketSaleMessage = "No sale, not enough tickets remaining";

       if(noOfTicketsDesired <= noOfTicketsRemaining){
         System.out.printf("%s",sellTicketMessage);
       }else{
        System.out.printf("%d",noTicketSaleMessage);
       }
    }
    
}

// class Human{
//     private String name;
//     private int age;
 
//     public Human(String name, int age){
//      this.name = name;
//      this.age = age;
//     }
 
//     public String toString(){
//      return "Name: " + name + "\n" + "Age: " + age;
//     }
// }