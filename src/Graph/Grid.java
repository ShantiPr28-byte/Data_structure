package Graph;

import java.util.*;

public class Grid {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1}; //up, down, left, right
    static int rowL;
    static int colL;

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}};
        rowL = grid.length;
        colL = grid[0].length;

        boolean[][] vis = new boolean[rowL][colL];

        int components = 0;

        for(int i = 0; i < rowL; i++) {
            for(int j = 0; j < colL; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    dfs(i, j, vis, grid);
                    components++;
                }
            }
        }

        System.out.println("number of component: " + components);
    }

    private static void dfs(int r, int c, boolean[][] vis, int[][] grid) {
        // base case
        //boundary and node
        if(r < 0 || c < 0 || r >= rowL || c >= colL || grid[r][c] == 0)
            return;
        if(vis[r][c] == true)
            return;

        vis[r][c] = true;
//
//        dfs(r-1, c, vis, grid); //up
//        dfs(r+1, c, vis, grid); //down
//        dfs(r, c-1, vis, grid); //left
//        dfs(r, c+1, vis, grid); //right

        for(int i = 0; i < 4; i++) {
            dfs(r+dr[i], c+dc[i], vis, grid);
        }
    }

}
