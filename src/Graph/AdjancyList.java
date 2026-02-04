package Graph;

import java.util.*;

public class AdjancyList {
    public static void main(String[] args) {
        int V, edge;
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        edge = sc.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < edge; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for(int i = 0; i < adjList.size(); i++) {
            for(int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
