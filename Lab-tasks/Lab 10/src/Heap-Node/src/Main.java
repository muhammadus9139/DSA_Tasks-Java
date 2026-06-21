public class Main{
public static void main(String[] args) {

    LinkedListHeap heap = new LinkedListHeap();

    heap.insert(10);
    heap.insert(20);
    heap.insert(5);
    heap.insert(15);
    heap.insert(30);
    heap.insert(3);

    System.out.println("Heap:");
    heap.printHeap();

    System.out.println("Deleted Min: " + heap.deleteMin());

    System.out.println("After deletion:");
    heap.printHeap();
    }
}