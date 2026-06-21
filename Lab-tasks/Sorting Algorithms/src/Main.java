
public class Main {

    public static void main(String[] args) {

        int[] arr = {5, 2, 9, 1, 6, 3};

        System.out.print("Original: ");
        print(arr);

        // Sirf yahan change karke different sort run karo

        BubbleSort.sort(arr);
        // SelectionSort.sort(arr);
        // InsertionSort.sort(arr);
        // QuickSort.sort(arr, 0, arr.length - 1);
        // MergeSort.sort(arr, 0, arr.length - 1);

        System.out.print("Sorted: ");
        print(arr);
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}