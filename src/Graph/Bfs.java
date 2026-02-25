package Graph;

import java.util.*;

public class Bfs {
    public static void main(String[] args) {
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
        ArrayList<Integer> ans = new ArrayList<>();
        ans = bfs(adj, vis, 0);
        for(int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i)+" ");
        }
    }

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int src) {
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        vis[src] = true;
        q.offer(src);

        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            for(int adjNode : adj.get(node)) {
                if(vis[adjNode] == false) {
                    vis[adjNode] = true;
                    q.offer(adjNode);
                }
            }
        }
        return ans;
        //time complexity = O(V+E)
        //space complexity = O(V)
    }
    // this is for connexted
    // try for non connected -> use a loop for every src

}
