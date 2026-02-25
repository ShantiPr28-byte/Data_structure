package Graph;

import java.util.*;

public class FoxAndNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[26];
        Arrays.fill(indegree, 0);

        for(int i = 0; i < words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                System.out.println("Impossible");
                return;
            }

            for(int k = 0; k < Math.min(word1.length(), word2.length()); k++) {
                char u = word1.charAt(k);
                char v = word2.charAt(k);
                if(u != v) {
                    adj.get(u-'a').add(v-'a');
                    indegree[v - 'a']++;
                    break;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < 26; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        //bfs
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()) {
            int node = q.poll();
            sb.append((char)(node + 'a'));
            for(int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) {
                    q.offer(adjNode);
                }
            }
        }

        int count = 0;
        for(int i = 0; i < 26; i++) {
            if(indegree[i] > 0) {
                count++;
            }
        }
        if(count == 0) {
            System.out.println(sb.toString());
        } else {
            System.out.println("Impossible");
        }
    }
}
