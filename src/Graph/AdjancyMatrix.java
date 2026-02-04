package Graph;

import java.util.*;

public class AdjancyMatrix {
    public static void main(String[] args) {
        int V, edges;
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        edges = sc.nextInt();
        int[][] matrix = new int[V+1][V+1];

        for(int i = 0; i < edges; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            matrix[u][v] = 1;
            matrix[v][u] = 1;
        }

        printM(matrix, V+1);
    }

    public static void printM(int[][] matrix, int len) {
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//Adjancy Matrix space complexity = V^2
