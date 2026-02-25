package Graph;
import java.util.*;

public class AdjancyList {
//    static class Edge {
//        int src;
//        int dest;
//
//        public Edge(int s, int d) {
//            this.src = s;
//            this.dest = d;
//        }
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int edges = sc.nextInt();

        //crating graph with arraylist of arraylist of integer
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        //vertices are starting from 1
        for(int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        //storing the edges in list of list
        for(int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            //for undirected graph
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        //printing the graph in the form of list of list
        for(int i = 0; i <=V; i++) {
            for(int j = 0; j < adjList.get(i).size(); j++) {
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }

//        //creating graph with array arraylist of edges
//        ArrayList<Edge>[] graph = new ArrayList[V+1];
//        for(int i = 0; i <= V; i++) {
//            graph[i] = new ArrayList<Edge>();
//        }
//
//        //storing the edge
//        for(int i = 0; i < edges; i++) {
//            int u = sc.nextInt();
//            int v = sc.nextInt();
//            graph[u].add(new Edge(u, v));
//            graph[v].add(new Edge(v, u));
//        }
//
//        //printing the graph
//        for(int i = 0; i <= V; i++) {
//            for(int j = 0; j < graph[i].size(); j++) {
//                System.out.print(graph[i].get(j).dest + " ");
//            }
//            System.out.println();
//        }
    }
}
