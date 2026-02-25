package Graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Dfs {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int V, edge;
        V = sc.nextInt();
        edge = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= V; i++) {

            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[V];

        dfs(0,vis,adj);
    }

    private static void dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[i]=true;
        System.out.println(i);

        for(int neighbour:adj.get(i)){
            if(!vis[neighbour]){
                dfs(neighbour,vis,adj);
            }
        }
    }
}
