class HashTable {

    int size = 10;
    int[] table;

    public HashTable() {
        table = new int[size];

        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    int hashFunction(int key) {
        return key % size;
    }

    void insert(int key) {

        int hash = hashFunction(key);

        for (int i = 0; i < size; i++) {

            int index = (hash + i * i) % size;

            if (table[index] == -1) {
                table[index] = key;
                return;
            }
        }

        System.out.println("Hash Table Full");
    }

    boolean search(int key) {

        int hash = hashFunction(key);

        for (int i = 0; i < size; i++) {

            int index = (hash + i * i) % size;

            if (table[index] == -1)
                return false;

            if (table[index] == key)
                return true;
        }

        return false;
    }

    void delete(int key) {

        int hash = hashFunction(key);

        for (int i = 0; i < size; i++) {

            int index = (hash + i * i) % size;

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
