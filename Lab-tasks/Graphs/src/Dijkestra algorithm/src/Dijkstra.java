import java.util.*;

public class Dijkstra {

    static class Pair {
        int node, dist;
        Pair(int n, int d) {
            node = n;
            dist = d;
        }
    }

    public void dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int src) {

        int dist[] = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();
            int u = curr.node;

            for (Pair nei : adj.get(u)) {

                int v = nei.node;
                int w = nei.dist;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        System.out.println("Dijkstra Result:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " : " + dist[i]);
        }
    }
}