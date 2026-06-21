import java.util.*;

public class Prim {

    static class Pair {
        int node, weight;
        Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }

    public int primMST(int V, ArrayList<ArrayList<Pair>> adj) {

        boolean visited[] = new boolean[V];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Pair(0, 0));

        int cost = 0;

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            if (visited[curr.node]) continue;

            visited[curr.node] = true;
            cost += curr.weight;

            for (Pair nei : adj.get(curr.node)) {
                if (!visited[nei.node]) {
                    pq.add(new Pair(nei.node, nei.weight));
                }
            }
        }

        return cost;
    }
}