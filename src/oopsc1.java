public class oopsc1 {
    static class Student{
        static  String clgname="KIET";
        String S_name;
        int rollno;
        public Student(String s,int r){
            this.S_name=s;
            this.rollno=r;


        }
        public void display(){
            System.out.println("College name = "+ clgname +" Student name "+S_name+" Student rollno "+rollno);
        }
    }
    public static void main(String[] args) {
        Student s1= new Student("Preetam",128);
        s1.display();

    }
}
