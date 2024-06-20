package $7_OOPS;

public class $10_super_keyword {
    public static void main(String[] args) {
        Scene se = new Scene();
        System.out.println(se.budget);
    }
}

class Movie {
    String budget = "300 Crores Rupees";
    Movie() {
        System.out.println(budget);
        System.out.println("Baahubali releases");
    }
}

class Scene extends Movie {
    Scene() {
        System.out.println(super.budget);
        System.out.println("Katappa betrays baahubali");
    }
    String budget = "10 Crores";
}