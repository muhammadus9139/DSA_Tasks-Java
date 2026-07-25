class HashTable {

    int size = 10;
    int[] table;

    public HashTable() {
        table = new int[size];

        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    int hash1(int key) {
        return key % size;
    }

    int hash2(int key) {
        return 7 - (key % 7);
    }

    void insert(int key) {

        int h1 = hash1(key);
        int h2 = hash2(key);

        for (int i = 0; i < size; i++) {

            int index = (h1 + i * h2) % size;

            if (table[index] == -1) {
                table[index] = key;
                return;
            }
        }

        System.out.println("Hash Table Full");
    }

    boolean search(int key) {

        int h1 = hash1(key);
        int h2 = hash2(key);

        for (int i = 0; i < size; i++) {

            int index = (h1 + i * h2) % size;

            if (table[index] == -1)
                return false;

            if (table[index] == key)
                return true;
        }

        return false;
    }

    void delete(int key) {

        int h1 = hash1(key);
        int h2 = hash2(key);

        for (int i = 0; i < size; i++) {

            int index = (h1 + i * h2) % size;

            if (table[index] == -1)
                return;

            if (table[index] == key) {
                table[index] = -1;
                System.out.println(key + " deleted.");
                return;
            }
        }
    }

    void display() {

        System.out.println("\nHash Table:");

        for (int i = 0; i < size; i++) {
            System.out.println(i + " : " + table[i]);
        }
    }
}
