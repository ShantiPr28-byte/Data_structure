package Graph;

import java.util.*;
public class IceSkating {
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        Pair[] points = new Pair[V];
        for(int i = 0; i < V; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            points[i] = new Pair(x, y);
        }

        boolean[] vis = new boolean[V];
        int component = 0;
        for(int i = 0; i < V; i++) {
            if(!vis[i]) {
                dfs(i, vis, points);
                component++;
            }
        }
        System.out.println(component-1);
    }
    private static void dfs(int node, boolean[] vis, Pair[] points) {
        vis[node] = true;

        for(int i = 0; i < points.length; i++) {
            if(!vis[i] && (points[node].x == points[i].x || points[node].y == points[i].y)) {

                dfs(i, vis, points);
            }
        }
    }
}
