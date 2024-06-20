package $7_OOPS;

public class $4_constructors {
    public static void main(String args[]) {
        Employee e1 = new Employee();
        e1.name = "Rohit";
        e1.exp = 5;
        e1.pass = "abcd";
        e1.fields[0] = "webDev";
        e1.fields[1] = "dsa";
        e1.fields[2] = "androidDev";

        Employee e2 = new Employee(e1);
        e2.pass = "xyze";
        e1.fields[2] = "iOSdev";
        // for (int i=0; i<3; i++) {
        //     System.out.println(e2.fields[i]);
        // }
        Employee e3 = new Employee(e1);
        System.out.println(e3.add.city);
        (e1.add).city = "Chandigarh";
        System.out.println((e3.add).city);
    }
}

class Employee {
    String name;
    int exp;
    String pass;
    String fields[];
    Address add = new Address(); 

    class Address {
        String city = "Hathras";
    }

    //shalloow copy constructor
    Employee(Employee e) {
        fields = new String[3];
        this.name = e.name;
        this.exp = e.exp;
        this.fields = e.fields;
        this.add = e.add;
    }

    // //deep copy constructor
    // Employee(Employee e) {
    //     fields = new String[3];
    //     this.name = e.name;
    //     this.exp = e.exp;
    //     this.add.city = (e.add.city);
    //     for (int i=0; i<fields.length; i++) {
    //         this.fields[i] = e.fields[i];
    //     }
    // }

    Employee() {
        fields = new String[3];
        System.out.println("Welcome in our Company");
    }
    Employee(String pass_name) {
        fields = new String[3];
        this.name = pass_name;
    }
    Employee(int updatedExp) {
        fields = new String[3];
        this.exp = updatedExp;
    }

}