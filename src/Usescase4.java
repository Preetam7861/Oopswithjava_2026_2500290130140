import java.util.Scanner;
public class Usescase4 {
 public   static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter age");
     int a = sc.nextInt();
     try{
        checkAge(a);}
     catch(AgeInvalidException e){
         System.out.println(e);
     }
     finally {
         sc.close();
     }

    }
    static void checkAge(int age){
     if(age<18) throw new AgeInvalidException("Age is not valid to vote");
    }

}
class AgeInvalidException extends RuntimeException{
    AgeInvalidException(String msg){
        super(msg);

    }

}
