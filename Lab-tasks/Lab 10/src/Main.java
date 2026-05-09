public class Main{
    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap(20);

        // ================= INSERT =================

        heap.insert(50);
        heap.insert(30);
        heap.insert(40);
        heap.insert(10);
        heap.insert(20);
        heap.insert(60);

        System.out.println("Heap after insertion:");
        heap.printHeap();

        // ================= SEARCH =================

        System.out.println("Search 40: " + heap.search(40));
        System.out.println("Search 100: " + heap.search(100));

        // ================= DELETE ROOT =================

        System.out.println("Deleted Root: " + heap.deleteRoot());

        System.out.println("Heap after root deletion:");
        heap.printHeap();

        // ================= DELETE SPECIFIC =================

        heap.deleteElement(30);

        System.out.println("Heap after deleting 30:");
        heap.printHeap();

        // ================= BUILD HEAP =================

        // Buildheap old heap data use ni krta new array leta ha
        // or us array ko maxheap ma likh rha yaha

        int[] arr = {5, 12, 8, 20, 1, 30};

        heap.buildHeap(arr);

        System.out.println("Heap after buildHeap:");
        heap.printHeap();

        // ================= HEAP SORT =================

        // Heap sort mai MAX HEAP ma ascenting ma arrange hota ha bcz
        // max heap ma largest element root pa hota ha to wo last ma aayega
        // 1 2 3 4 5 6 7 8

        heap.heapSort();

        System.out.println("Heap after HeapSort:");
        heap.printHeap();
    }
}