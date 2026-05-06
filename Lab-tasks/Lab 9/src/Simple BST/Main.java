
// Main for BST
public class Main {
    public static void main(String[] args) {

        BST tree = new BST();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);


        System.out.println("Inorder:");
        tree.inorder(tree.root);

        System.out.println("\nSearch 40: " + tree.search(40));

        tree.delete(30);

        System.out.println("After deletion:");
        tree.inorder(tree.root);


    }
}