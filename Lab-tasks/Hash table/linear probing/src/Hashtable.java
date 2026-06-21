
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
        int index = hashFunction(key);

        while (table[index] != -1) {
            index = (index + 1) % size;
        }

        table[index] = key;
    }

    boolean search(int key) {
        int index = hashFunction(key);
        int start = index;

        while (table[index] != -1) {

            if (table[index] == key)
                return true;

            index = (index + 1) % size;

            if (index == start)
                break;
        }

        return false;
    }

    void delete(int key) {
        int index = hashFunction(key);
        int start = index;

        while (table[index] != -1) {

            if (table[index] == key) {
                table[index] = -1;
                return;
            }

            index = (index + 1) % size;

            if (index == start)
                break;
        }
    }

    void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + ":" + table[i]);
        }
    }
}

