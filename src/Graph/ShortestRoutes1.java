package Graph;

import java.util.*;

public class ShortestRoutes1 {
    static class Pair {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }
        for(int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            adj.get(a).add(new Pair(b, c));
            adj.get(b).add(new Pair(a, c));
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.dist, y.dist));
        pq.offer(new Pair(1, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.dist;

            if(d > distance[u]) continue;
            for(Pair adjNode : adj.get(u)) {
                int v = adjNode.node;
                int costu_v = adjNode.dist;
                if(distance[v] > distance[u] + costu_v) {
                    distance[v] = distance[u] + costu_v;
                    pq.offer(new Pair(v, distance[v]));
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            System.out.print(distance[i] + " ");
        }
    }
}
