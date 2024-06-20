package $7_OOPS;

public class $7_abstraction {
    public static void main(String[] args) {
        Horse h = new Horse();
        h.eat();
        h.walk();

        Chicken ch = new Chicken();
        ch.eat();
        ch.walk();

        // Creatrue an = new Creatrue();
        /* object creation is not allowed for abstract class. */

        System.out.println(h.color);
        h.changeColor("blue");
        System.out.println(h.color);

        Mustang myHorse = new Mustang();
        // Creatrue -> Horse -> Mustang
        System.out.println(myHorse.color);
    }
}

abstract class Creatrue {
    String color;
    Creatrue() {
        color = "white";
        System.out.println("Creatrue Constructor called");
    }
    void eat() {
        System.out.println("Creatrue eats");
    }
    abstract void walk();
}

class Horse extends Creatrue {
    Horse() {
        System.out.println("Horse Constructor called");
    }
    void changeColor(String newColor) {
        this.color = newColor;
    }
    void walk() {
        System.out.println("Horse walks on 4 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang Constructor called");
    }
}

class Chicken extends Creatrue {
    void changeColor(String newColor) {
        this.color = newColor;
    }
    void walk() {
        System.out.println("Chicken walks on 2 legs");
    }
}