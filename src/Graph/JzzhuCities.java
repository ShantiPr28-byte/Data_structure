package Graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class JzzhuCities {
    static class Pair{
        int to_city;
        long cost;
        public Pair(int to_city, long cost) {
            this.to_city = to_city;
            this.cost = cost;
        }
    }

    static class State{
        int to_city;
        long cost;
        int flag;
        public State(int to_city, long cost,int flag) {
            this.to_city = to_city;
            this.cost = cost;
            this.flag = flag;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k =Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Pair>>adj = new ArrayList<>();
        for(int i = 0 ; i <=n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i = 1; i<=m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }
        long  []dist = new long[n+1];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[1] = 0;
        PriorityQueue<State>pq = new PriorityQueue<>((a,b)->Long.compare(a.cost,b.cost));
        pq.offer(new State(1,0,0));// 0->road, 1->train
        for(int i = 0; i < k ; i++)
        {
            st = new StringTokenizer(br.readLine());
            int newCity = Integer.parseInt(st.nextToken());
            long newCityCost = Long.parseLong(st.nextToken());
            pq.offer(new State(newCity,newCityCost,1));
        }
        int remove =  0;
        boolean[]vis = new boolean[n+1];
        while(!pq.isEmpty())
        {
            State curr = pq.poll();
            int u = curr.to_city;
            long weight = curr.cost;
            int via  = curr.flag;

            if(dist[u] <= weight && via == 1)
            {
                remove++;
                continue;
            }
            else if(dist[u] > weight && via == 1)
            {
                dist[u] = weight;
                continue;
            }
            if(vis[u])continue;
            vis[u] = true;
            if(dist[u]<weight)continue;
            for(Pair adjNode : adj.get(u))
            {
                int v = adjNode.to_city;
                long C = adjNode.cost;
                if(dist[v] > weight + C)
                {
                    dist[v] = weight + C ;
                    pq.offer(new State(v,dist[v],0));
                }
            }

        }
        System.out.println(remove);
    }
}
