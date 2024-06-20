package $1_Basic_Java;
public class $11_functions {
    public static void printhelloworld() {
        System.out.println("Hello World");
        System.out.println("Hello World");
    }
    public static int product(int num1, int num2) {
        int product = num1 + num2;
        return product;
    }
    public static void swap(int a, int b) {
        // swap - exchange values
        int temp = a;
        a = b;
        b = temp;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        swap(a, b);
        System.out.println(product(a,b));
    }
}
