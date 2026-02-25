package DisjointSet;

import java.sql.SQLOutput;
import java.util.*;

public class RoadConstruction {
    static class Pair {
        int u;
        int v;
        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            q.offer(new Pair(u, v));
        }

        int[] parent = new int[n+1];
        for(int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        int[] size = new int[n+1];
        Arrays.fill(size, 1);

        int component = n;
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.u;
            int y = curr.v;
            if(union(x, y, parent, size)) {
                component--;
            }
            System.out.print(component + " ");
            int maxSize = 1;
            for(int i = 1; i <= n; i++) {
                maxSize = Integer.max(maxSize, size[i]);
            }
            System.out.println(maxSize);
        }
    }

    public static int find(int x, int[] parent) {
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    public static boolean union(int x, int y, int[] parent, int[] size) {
        int par_x = find(x, parent);
        int par_y = find(y, parent);

        if(par_x == par_y) return false;

        if(size[par_x] > size[par_y]) {
            parent[par_y] = par_x;
            size[par_x] = size[par_x] + size[par_y];
        } else if(size[par_y] > size[par_x]) {
            parent[par_x] = par_y;
            size[par_y] = size[par_y] + size[par_x];
        } else {
            parent[par_x] = par_y;
            size[par_y] = size[par_y] + size[par_x];
        }
        return true;
    }
}
