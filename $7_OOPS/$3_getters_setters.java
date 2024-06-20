package $7_OOPS;

public class $3_getters_setters {
    public static void main(String[] args) {
        Pen_ p1 = new Pen_();
        p1.setColor("blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
        p1.setColor("Yellow");
        System.out.println(p1.getColor());
    }
}

class Pen_ {
    private String color;
    private int tip;

    String getColor() {
        return this.color; //'this' represents the object of here
    }

    int getTip() {
        return this.tip;
    }

    void setColor(String newColor) {
        this.color = newColor;
    }
    
    void setTip(int newTip) {
        this.tip = newTip;
    }
}
