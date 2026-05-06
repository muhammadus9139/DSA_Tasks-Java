

// Simple BST with insert,delete and search and traversals
public class BST {
    Node root;

    BST(){
        root=null;
    }

    Node insertrec(Node root,int value){
        if(root==null){
            root=new Node(value);
            return root;
        }

        if(value<root.data){
            root.left=insertrec(root.left,value);
        }
        else{
            root.right=insertrec(root.right,value);
        }
        return root;
    }

    void insert(int value){
        root=insertrec(root,value);
    }

    boolean searchrec(Node root,int key){
        if(root==null){
            return false;
        }

        if(root.data==key){
            return true;
        }

        if(key<root.data){
            return searchrec(root.left,key);
        }

        else{
            return searchrec(root.right,key);
        }
    }

    boolean search(int key){
        return searchrec(root,key);
    }


    Node findMin(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }


    Node deleterec(Node root,int value){
        if(root==null) {
            return root;
        }

        if(value<root.data){
            root.left=deleterec(root.left,value);
        }

        else if(value>root.data){
            root.right=deleterec(root.right,value);
        }

        else{
            // no element
            if(root.left==null && root.right==null)
                return null;

             // for only one node
            if(root.left==null)
                return root.right;
            // for only one node
            else if(root.right==null)
                return root.left;

            // for two child nodes
            Node temp=findMin(root.right);
            root.data=temp.data;
            root.right=deleterec(root.right,temp.data);
        }
        return root;
    }

    void delete(int value){
        root=deleterec(root,value);
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
