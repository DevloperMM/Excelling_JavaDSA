package $7_OOPS;

public class $8_interfaces {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();
        Rook r = new Rook();
        r.moves();
    }
}

interface Herbivore {
    void eat_grass();
}

interface Carnivore {
    void eat_flesh();
}

class Bear implements Herbivore, Carnivore {
    public void eat_grass() {
        System.out.println("Inherited from Herbivores");
    }
    public void eat_flesh() {
        System.out.println("Inherited from Carnivores");
    }
}


interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up|down|left|right|diagonal_in-all-direction");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up|down|left|right");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("up|down|left|right|diagonal_by-1-step)");
    }
}
