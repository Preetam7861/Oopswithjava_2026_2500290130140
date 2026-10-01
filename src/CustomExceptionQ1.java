
import java.util.*;
//custom exception
class EmployeeException extends Exception{
    EmployeeException(String msg){ // constructor
        super(msg);//parent constructor ko bej rha h msg ko

    }
}
//Employee class
        class Employee{
            private String name;
            private double salary;
            Employee(String name,double salary){
                this.name=name;
                this.salary=salary;
            }
            void display() throws EmployeeException{
                System.out.println("Name : "+name);
                System.out.println("Salary : "+salary);
                if(salary<2000){
                    throw new EmployeeException("Salary is below 2000");
                }

            }

        }



public class CustomExceptionQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name:");
        String name = sc.nextLine();
        System.out.println("Enter salary");
        double salary = sc.nextDouble();
        Employee e1 = new Employee(name,salary);
        try{
            e1.display();
        }
        catch (EmployeeException e){
            System.out.println("Exception:"+e.getMessage());

        }



    }
}
