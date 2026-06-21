import java.util.*;

public class Kruskal {

    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    int parent[];

    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        parent[find(a)] = find(b);
    }

    public int kruskal(int V, ArrayList<Edge> edges) {

        parent = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;

        Collections.sort(edges, (a, b) -> a.w - b.w);

        int cost = 0;

        for (Edge e : edges) {
            if (find(e.u) != find(e.v)) {
                cost += e.w;
                union(e.u, e.v);
            }
        }

        return cost;
    }
}