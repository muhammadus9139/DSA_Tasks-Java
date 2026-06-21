
import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // add edge (undirected graph)
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void printGraph() {
        for (int i = 0; i < V; i++) {
            System.out.print(i + " -> ");
            for (Integer node : adj[i]) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}