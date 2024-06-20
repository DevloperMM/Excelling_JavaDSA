package $7_OOPS;

public class $11_questions {
    public static void main(String[] args) {
        Vehicle v = new Car();
        v.print(); //method over-riding
        //v.print1(); --> not allowed as parent class can not access child methods and properties

        System.out.println(v.count);
    }
}

class Vehicle {
    int count;
    void print() {
        System.out.println("Base/Parent Class");
    }
}
class Car extends Vehicle {
    // void print() {
    //     System.out.println("Derived Class");
    // }
    void print1() {
        System.out.println("Derived Class");
    }
}