public class AVLTree{
    Node root;


    // Height used in getbalance and L,R rotations
    int height(Node node){
      if(node==null){
          return 0;
      }
        return node.height;
    }

    //Max use in right and left rotations
    int max(int a,int b){
        return (a>b)?a:b;
    }


    int getbalance(Node node){
        if(node==null){
            return 0;
        }
        return height(node.left)-height(node.right);
    }


    //RIGHT ROTATION
    Node rightrotation(Node y){
        Node x=y.left;
        Node T2=x.right;

        x.right=y;
        y.left= T2;

        y.height=max(height(y.left),height(y.right))+1;
        x.height=max(height(x.left),height(x.right))+1;

        return x;
    }


    //LEFT ROTATION
    Node leftrotation(Node x){
        Node y=x.right;
        Node T2=y.left;

        y.left=x;
        x.right=T2;

        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;

        return y;
    }

    //Insert
    Node insert(Node root,int value){
        if(root==null){
            return new Node(value);
        }

        if(value<root.value){
            root.left=insert(root.left,value);
        }

        else if(value>root.value){
            root.right=insert(root.right,value);
        }

        else {
            return root;
        }

        root.height=1+max(height(root.left),height(root.right));

        int balance=getbalance(root);

        //LL
        if(balance>1 && value < root.left.value){
            return rightrotation(root);
        }

        //RR
        if(balance<-1 && value > root.right.value){
            return leftrotation(root);
        }

        //RL
        if(balance<-1 && value<root.right.value){
           root.right=rightrotation(root.right);
           return leftrotation(root);
        }

        //LR
        if(balance>1 && value>root.left.value){
           root.left=leftrotation(root.left);
           return rightrotation(root);
        }
        return root;
    }

    //Search
    Node search(Node node,int value){
        if(node==null || node.value==value){
            return node;
        }
        if(value<node.value){
            return search(node.left,value);
        }
        return search(node.right,value);
    }


    // Find min node from the right subtree
    // for two children deletion
    Node findmin(Node node){

        Node current=node;

        while(current.left!=null){
            current=current.left;
        }
        return current;
    }




    //DELETE
    Node delete(Node root,int value){
        if(root==null){
            return root;
        }

        if(value<root.value){
            root.left=delete(root.left,value);
        }

        else if(value>root.value){
            root.right=delete(root.right,value);
        }

        else{
            // For one child or no child
            if(root.left==null)
                return root.right;

            else if(root.right==null)
                return  root.left;

            //For Two children
            Node temp=findmin(root.right);
            root.value=temp.value;
            root.right=delete(root.right,temp.value);
        }

        // Again check
        if(root==null){
            return root;
        }

        root.height=1+max(height(root.left),height(root.right));

        int balance=getbalance(root);

        //LL
        if(balance>1 && getbalance(root.left)>=0){
            return rightrotation(root);
        }

        //LR
        if(balance>1 && getbalance(root.right)<0){
          root.left=leftrotation(root.left);
          return rightrotation(root);
        }

        //RR
        if(balance<-1 && getbalance(root.right)<=0){
            return leftrotation(root);
        }

        //RL
        if(balance<-1 && getbalance(root.left)>0){
            root.right=rightrotation(root.right);
            return leftrotation(root);
        }
        return root;
    }

   // Inorder traversal
    void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.value+" ");
            inorder(root.right);
        }
    }
}