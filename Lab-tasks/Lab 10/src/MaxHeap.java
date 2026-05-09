import java.util.*;

class MaxHeap {

    int[] heap;
    int size;
    int capacity;

    // Constructor
    MaxHeap(int capacity) {
        this.capacity = capacity;
        heap = new int[capacity];
        size = 0;
    }

    // Parent index
    int parent(int i) {
        return (i - 1) / 2;
    }

    // Left child index
    int left(int i) {
        return 2 * i + 1;
    }

    // Right child index
    int right(int i) {
        return 2 * i + 2;
    }

    // Swap function
    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    // ================= INSERTION =================

    void insert(int value) {

        if (size == capacity) {
            System.out.println("Heap Full");
            return;
        }

        // Insert at end
        heap[size] = value;

        int current = size;
        size++;

        // Bubble Up
        while (current > 0 && heap[current] > heap[parent(current)]) {

            swap(current, parent(current));
            current = parent(current); // apni pos change hui yaha parent pr chsla gya
            // or current b waha i kr liye change
        }
    }

    // ================= HEAPIFY =================


    void heapify(int i) {

        int largest = i;

        int leftChild = left(i);
        int rightChild = right(i);

        // Compare left child
        if (leftChild < size && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }

        // Compare right child
        if (rightChild < size && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        // Swap if needed
        if (largest != i) {

            swap(i, largest);

            // Recursive heapify
            heapify(largest);
        }
    }

    // ================= DELETE ROOT =================

    // Default element root se del hota ha

    int deleteRoot() {

        if (size <= 0) {
            System.out.println("Heap Empty");
            return -1;
        }

        int root = heap[0];

        // Move last element to root
        heap[0] = heap[size - 1];

        size--;

        // Fix heap
        heapify(0);

        return root;
    }

    // ================= SEARCH =================

    boolean search(int key) {

        for (int i = 0; i < size; i++) {

            if (heap[i] == key) {
                return true;
            }
        }

        return false;
    }

    // ================= DELETE SPECIFIC ELEMENT =================

    void deleteElement(int value) {

        int index = -1;

        // Find element
        for (int i = 0; i < size; i++) {

            if (heap[i] == value) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Element not found");
            return;
        }

        // Replace with last element
        heap[index] = heap[size - 1];

        size--;

        // Fix heap
        heapify(index);

        System.out.println(value + " deleted");
    }

    // ================= BUILD HEAP =================

    // Buildheap old heap data use ni krta new array leta ha
    // or us array ko maxheap ma likh rha yaha
     // new array main ma dia ha hm ne



    void buildHeap(int[] arr) {

        size = arr.length;

        for (int i = 0; i < arr.length; i++) {
            heap[i] = arr[i];
        }

        // Start from last non-leaf node
        for (int i = size / 2 - 1; i >= 0; i--) {

            heapify(i);
        }
    }

    // ================= HEAP SORT =================

    // Heap sort mai MAX HEAP ma ascenting ma arrange hota ha bcz
    // max heap ma largest element root pa hota ha to wo last ma aayega
    // 1 2 3 4 5 6 7 8

    // Min HEAP ma descenting order ma sort ho ga
    // 7 6 5 4 3 2 1
    // chota element root pa hota ha to wo last ma jayega
    // Abhi tow ye max heap ha

    void heapSort() {

        int originalSize = size;

        for (int i = size - 1; i > 0; i--) {

            swap(0, i);

            size--;

            heapify(0);
        }

        size = originalSize;
    }

    // ================= PRINT =================

    void printHeap() {

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}
