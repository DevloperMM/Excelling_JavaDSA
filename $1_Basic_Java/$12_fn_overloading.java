package $1_Basic_Java;
public class $12_fn_overloading {
    public static int sum(int a, int b) {
        return a+b;
    }
    public static float sum(float a, float b) {
        return a+b;
    }
    public static int sum(int a, int b, int c) {
        return a+b+c;
    }
    public static void main(String[] args) {
        System.out.println(sum(3,5));
        System.out.println(sum(4,5,6));
        System.out.println(sum(4.56f,3.2f));
    }
}
