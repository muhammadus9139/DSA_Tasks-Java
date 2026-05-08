public class Main{
    public static void main(String args[]) {
        AVLTree tree=new AVLTree();

        tree.root=tree.insert(tree.root,10);
        tree.root=tree.insert(tree.root,1);
        tree.root=tree.insert(tree.root,2);
        tree.root=tree.insert(tree.root,3);
        tree.root=tree.insert(tree.root,6);
        tree.root=tree.insert(tree.root,0);
        tree.root=tree.insert(tree.root,9);

        System.out.println("Inorder traversal");
        tree.inorder(tree.root);

        //search
        System.out.println();
        Node found=tree.search(tree.root,2);

        if(found!=null){
            System.out.println("Search: "+found.value);
        }
        else{
            System.out.println("Search element not found....");
        }

        //delete
        // This few lines for else portion if deleting term not found
        int delete=60;
        Node deletefound=tree.search(tree.root,delete);
        tree.root=tree.delete(tree.root,delete);

        int deletevalue=delete;// we use this bcz if we dont use then it will delete
         // exact value but here print value after rotation

        if(deletefound!=null){
            System.out.println("Deleted: "+deletevalue);
            System.out.println("After deletion");
        }
        else{
            System.out.println("Delete element not found....");
        }

        // Inorder traversal after deletion
        tree.inorder(tree.root);
    }
}
