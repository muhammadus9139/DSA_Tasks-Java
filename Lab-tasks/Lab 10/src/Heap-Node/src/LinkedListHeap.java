public class LinkedListHeap {

    private HeapNode root;
    private HeapNode lastNode;

    // ---------------- INSERT ----------------
    public void insert(int value) {
        HeapNode newNode = new HeapNode(value);

        if (root == null) {
            root = lastNode = newNode;
            return;
        }

        HeapNode parent = findInsertionParent();

        if (parent.left == null)
            parent.left = newNode;
        else
            parent.right = newNode;

        newNode.parent = parent;
        lastNode = newNode;

        heapifyUp(newNode);
    }

    // ---------------- HEAPIFY UP ----------------
    private void heapifyUp(HeapNode node) {
        while (node.parent != null && node.data < node.parent.data) {
            swap(node, node.parent);
            node = node.parent;
        }
    }

    // ---------------- DELETE MIN (ROOT) ----------------
    public int deleteMin() {
        if (root == null) throw new IllegalStateException("Empty Heap");

        int min = root.data;

        if (root == lastNode) {
            root = lastNode = null;
            return min;
        }

        root.data = lastNode.data;

        HeapNode newLast = findNewLastNode();

        if (lastNode.parent.left == lastNode)
            lastNode.parent.left = null;
        else
            lastNode.parent.right = null;

        lastNode = newLast;

        heapifyDown(root);

        return min;
    }

    // ---------------- HEAPIFY DOWN ----------------
    private void heapifyDown(HeapNode node) {
        while (node.left != null) {

            HeapNode smaller = node.left;

            if (node.right != null && node.right.data < smaller.data)
                smaller = node.right;

            if (node.data <= smaller.data)
                break;

            swap(node, smaller);
            node = smaller;
        }
    }

    // ---------------- FIND INSERT POSITION ----------------
    private HeapNode findInsertionParent() {
        HeapNode current = lastNode;

        while (current != root && current == current.parent.right)
            current = current.parent;

        if (current != root) {
            if (current.parent.right != null) {
                current = current.parent.right;
                while (current.left != null)
                    current = current.left;
            } else {
                current = current.parent;
            }
        } else {
            while (current.left != null)
                current = current.left;
        }

        return current;
    }

    // ---------------- FIND LAST NODE ----------------
    private HeapNode findNewLastNode() {
        HeapNode current = lastNode;

        while (current != root && current == current.parent.left)
            current = current.parent;

        if (current != root)
            current = current.parent.left;

        while (current.right != null)
            current = current.right;

        return current;
    }

    // ---------------- SWAP ----------------
    private void swap(HeapNode a, HeapNode b) {
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }

    // ---------------- PRINT LEVEL ORDER ----------------
    public void printHeap() {
        if (root == null) {
            System.out.println("Heap empty");
            return;
        }

        java.util.Queue<HeapNode> q = new java.util.LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            HeapNode cur = q.poll();
            System.out.print(cur.data + " ");

            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }

        System.out.println();
    }
}