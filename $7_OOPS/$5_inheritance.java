package $7_OOPS;

public class $5_inheritance {
    public static void main(String[] args) {
        // Fish shark = new Fish();
        // shark.eat();

        // Dog dobby = new Dog();
        // dobby.legs = 4;
        // System.out.println(dobby.legs);
        // dobby.eat();

        Bird ostrich = new Bird();
        ostrich.color = "white";
        System.out.println(ostrich.color);
    }
}

//Base Class
class Animal {
    String color;
    void eat() {
        System.out.println("eats");
    }
    void breathe() {
        System.out.println("breathes");
    }
}

// //Single Level Inheritance
// class Fish extends Animal {
//     int fins;
//     void swim() {
//         System.out.println("Swims in water");
//     }
// }

// //Multi Level Inheritance
// class Mammal extends Animal {
//     int legs;
// }
// class Dog extends Mammal {
//     String breed;
// }

//Hierarchial Inheritance
class Mammal extends Animal {
    void walk() {
        System.out.println("Walks");
    }
}
class Fish extends Animal {
    void swim() {
        System.out.println("Swims");
    }
}
class Bird extends Animal {
    void fly() {
        System.out.println("flies");
    }
}

//Hybrid Inheritance --> any inheritance of any derived class in any class or subclass.