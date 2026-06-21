import java.util.*;

public class Main {

  public static void main(String[] args) {

    int V = 5;

    ArrayList<ArrayList<Dijkstra.Pair>> adj = new ArrayList<>();

    for (int i = 0; i < V; i++)
      adj.add(new ArrayList<>());

    // directed weighted graph
    adj.get(0).add(new Dijkstra.Pair(1, 2));
    adj.get(0).add(new Dijkstra.Pair(2, 4));
    adj.get(1).add(new Dijkstra.Pair(2, 1));
    adj.get(1).add(new Dijkstra.Pair(3, 7));
    adj.get(2).add(new Dijkstra.Pair(4, 3));

    Dijkstra d = new Dijkstra();
    d.dijkstra(V, adj, 0);
  }
}