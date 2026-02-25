package Graph;

import java.util.*;

public class C20Dijkstra {
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
            int w = sc.nextInt();

            adj.get(a).add(new Pair(b, w));
            adj.get(b).add(new Pair(a, w));
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;
        int[] parent = new int[n+1];
        Arrays.fill(parent, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.dist, b.dist));
        pq.add(new Pair(1, 0));

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
                    parent[v] = u;
                    pq.offer(new Pair(v, distance[v]));
                }
            }
        }

        if(distance[n] == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }

        ArrayList<Integer> path = new ArrayList<>();
        for(int i = n; i != -1; i = parent[i]) {
            path.add(i);
        }
        Collections.reverse(path);

        for(int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
    }
}
