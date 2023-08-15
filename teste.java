class Simple{  
    public static void main(String args[]){  
     System.out.println("Hello Java");  
     String valor = Teste.methTest(3);
     System.out.println(valor);
    }  
}  

class Teste{
    public static String methTest(int num){
        String texto = "O número digitado foi: '" + num + "\'.";
        return texto;
    }
}