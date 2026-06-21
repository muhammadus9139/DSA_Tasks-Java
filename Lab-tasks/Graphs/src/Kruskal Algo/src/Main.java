import java.util.*;

public class Main {

  public static void main(String[] args) {

    int V = 4;

    ArrayList<Kruskal.Edge> edges = new ArrayList<>();

    edges.add(new Kruskal.Edge(0, 1, 10));
    edges.add(new Kruskal.Edge(0, 2, 6));
    edges.add(new Kruskal.Edge(0, 3, 5));
    edges.add(new Kruskal.Edge(2, 3, 4));
    edges.add(new Kruskal.Edge(1, 3, 15));

    Kruskal k = new Kruskal();
    int cost = k.kruskal(V, edges);

    System.out.println("Kruskal MST Cost: " + cost);
  }
}