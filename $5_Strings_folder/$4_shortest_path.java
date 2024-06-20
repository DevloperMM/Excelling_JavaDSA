package $5_Strings_folder;

public class $4_shortest_path {
    public static float displacement(String path) {
        int x=0, y=0;
        for (int i=0; i<path.length(); i++) {
            char dir = path.charAt(i);

            if (dir == 'N') {
                x++;
            } else if (dir == 'S') {
                x--;
            } else if (dir == 'E') {
                y++;
            } else {
                y--;
            }
        }
        return (float) Math.sqrt(x*x + y*y);
    }
    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(displacement(path));
    }
}
