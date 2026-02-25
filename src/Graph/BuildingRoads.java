package Graph;

import java.util.*;

public class BuildingRoads {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cities = sc.nextInt();
        int roads = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= cities; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < roads; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[cities+1];
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 1; i <= cities; i++) {
            if(!vis[i]) {
                ans.add(i);
                dfs(i, adj, vis);
            }
        }
        System.out.println(ans.size()-1);

        for(int i = 0; i < ans.size()-1; i++) {
            System.out.print(ans.get(i) + " " + ans.get(i+1));
        }
        System.out.println();
    }

    private static void dfs(int s, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[s] = true;

        for(int curr : adj.get(s)) {
            if(!vis[curr]) {
                dfs(curr, adj, vis);
            }
        }
    }
}
