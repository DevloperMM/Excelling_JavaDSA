package $7_OOPS;

public class $1_basics_oops {
    public static void main(String[] args) {
        // By convention main function should be public and static

        Pen p1 = new Pen(); //created a pen object called p1
        p1.setColor("blue");
        System.out.println(p1.color);
        p1.setTip(5);
        System.out.println(p1.tip);
        //p1.setColor("Yellow");
        p1.color = "Yellow";
        System.out.println(p1.color);
    }
}

class Pen {
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }
    
    void setTip(int newTip) {
        tip = newTip;
    }
}