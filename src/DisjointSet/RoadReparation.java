package DisjointSet;

import java.util.*;

public class RoadReparation {
    static class Pair {
        int u;
        int v;
        int c;
        public Pair(int u, int v, int c) {
            this.u = u;
            this.v = v;
            this.c = c;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.c, b.c));
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();

            pq.offer(new Pair(u, v, c));
        }

        int[] parent = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int[] rank = new int[n+1];
        int totalCost = 0;
        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int x = curr.u;
            int y = curr.v;
            int cost = curr.c;

            if(union(x, y, parent, rank)) {
                totalCost += cost;
            }
        }
        int count = 0;
        for(int i = 1; i < parent.length; i++) {
            if(parent[i] == i) {
                count++;
            }
        }
        if(count == 1) {
            System.out.println(totalCost);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    public static int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    public static boolean union(int x, int y, int[] parent, int[] rank) {
        int par_x = find(x, parent);
        int par_y = find(y, parent);

        if(par_x == par_y) return false;

        if(rank[par_x] > rank[par_y]) {
            parent[par_y] = par_x;
        } else if(rank[par_y] > rank[par_x]) {
            parent[par_x] = par_y;
        } else {
            parent[par_x] = par_y;
            rank[par_y]++;
        }
        return true;
    }
}
