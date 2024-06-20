package $22_Graphs;

public class $14_floodFill_algo {
    static void helper(int[][] image, int sr, int sc, int color, boolean vis[][], int old) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return;
        }
        if (vis[sr][sc] || image[sr][sc] != old) {
            return;
        }

        image[sr][sc] = color;
        vis[sr][sc] = true;
        
        //left
        helper(image, sr, sc-1, color, vis, old);
        //right
        helper(image, sr, sc+1, color, vis, old);
        //up
        helper(image, sr-1, sc, color, vis, old);
        //down
        helper(image, sr+1, sc, color, vis, old);

        return;
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, vis, image[sr][sc]);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,0,1},
                        {1,1,0},
                        {1,0,1}};
        
        int sr = 0, sc = 1, color = 2;
    
        int ans[][] = floodFill(image, sr, sc, color);
        for (int i=0; i<ans.length; i++) {
            for (int j=0; j<ans[0].length; j++) {
                System.out.print(ans[i][j] + "  ");
            }
            System.out.println();
        }
    }
}