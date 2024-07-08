package book.ch4.syncinheri;

public class Student extends People{

    int id;

    Student(String name){
        super(name);
    }

    public static void main(String[] args){
        People p = new People("Zhang");
        Student s = new Student("Yang");
        System.out.println(s.getName());
    }


}
