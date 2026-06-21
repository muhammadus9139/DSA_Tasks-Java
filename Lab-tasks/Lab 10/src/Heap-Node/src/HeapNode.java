class HeapNode {
    int data;
    HeapNode left, right, parent;

    HeapNode(int data) {
        this.data = data;
        this.left = this.right = this.parent = null;
    }
}