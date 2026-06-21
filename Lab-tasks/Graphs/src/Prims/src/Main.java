import java.util.*;

public class Main {

    public static void main(String[] args) {

        int V = 4;

        ArrayList<ArrayList<Prim.Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new Prim.Pair(1, 10));
        adj.get(1).add(new Prim.Pair(0, 10));

        adj.get(0).add(new Prim.Pair(2, 6));
        adj.get(2).add(new Prim.Pair(0, 6));

        adj.get(0).add(new Prim.Pair(3, 5));
        adj.get(3).add(new Prim.Pair(0, 5));

        adj.get(2).add(new Prim.Pair(3, 4));
        adj.get(3).add(new Prim.Pair(2, 4));

        Prim p = new Prim();
        int cost = p.primMST(V, adj);

        System.out.println("Prim MST Cost: " + cost);
    }
}