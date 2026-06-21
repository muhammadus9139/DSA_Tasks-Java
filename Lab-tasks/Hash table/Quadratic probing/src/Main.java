
public class Main {

    public static void main(String[] args) {

        HashTable ht = new HashTable();

        ht.insert(15);
        ht.insert(25);
        ht.insert(35);
        ht.insert(45);

        ht.display();

        System.out.println("\nSearch 25: " + ht.search(25));
        System.out.println("Search 50: " + ht.search(50));

        ht.delete(25);

        ht.display();
    }
}