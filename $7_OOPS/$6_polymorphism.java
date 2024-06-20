package $7_OOPS;

public class $6_polymorphism {
    public static void main(String[] args) {

        Calculator calc = new Calculator();
        System.out.println(calc.sum(2,3));
        System.out.println(calc.sum(1.5f,2.2f));
        System.out.println(calc.sum(2,4,6));

        Son son = new Son();
        System.out.println(son.bike());
    }
}

//Compile time polymorphism
class Calculator {
    int sum(int a, int b) {
        return a+b;
    }
    float sum(float a, float b) {
        return a+b;
    }
    int sum(int a, int b, int c) {
        return a+b+c;
    }
}

//Run time polymorphism
class Papa {
    String bike() {
        return "It is papa's bike";
    }
}
class Son extends Papa {
    String bike() {
        return "It is son's bike";
    }
}
