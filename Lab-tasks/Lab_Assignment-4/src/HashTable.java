

//SP25-BCS-151

class HashTable {

    String[] keys;
    String[] values;
    int size;


    HashTable(int size) {
        keys = new String[size];
        values = new String[size];
        this.size = size;
    }

    // Hash index nikala ha using Java hashcode()
    int hashFunction(String key) {
        return Math.abs(key.hashCode())%size;
    }


    void insert(String key, String value) {

        int index = hashFunction(key);

        // Linear Probing
        while (keys[index] != null){

            // agr same key pehly b exist krti ho
            if (keys[index].equals(key)) {
                values[index] = value;
                System.out.println("Value Updated!");
                return;
            }

            index = (index + 1) % size;
        }

        keys[index] = key;
        values[index] = value;

        System.out.println("Inserted at index: " + index);
    }


    void search(String key) {

        int index = hashFunction(key);
        int start = index;

        while (keys[index] != null) {

            if (keys[index].equals(key)) {
                System.out.println("Key Found!");
                System.out.println("Index: " + index);
                System.out.println("Value: " + values[index]);
                return;
            }

            index = (index + 1) % size;


            if (index == start)
                break;
        }

        System.out.println("Key Not Found!");
    }


    void delete(String key) {

        int index = hashFunction(key);
        int start = index;

        // find key
        while (keys[index] != null) {

            if (keys[index].equals(key)) {

                // value and key delete ki yaha
                keys[index] = null;
                values[index] = null;

                System.out.println("Deleted");

                // rehash elements after deleted position
                int next = (index + 1) % size;

                while (keys[next] != null) {
                    String tempKey = keys[next];
                    String tempValue = values[next];

                    keys[next] = null;
                    values[next] = null;

                    insert(tempKey, tempValue);
                    next = (next + 1) % size;
                }

                return;
            }

            index = (index + 1) % size;

            if (index == start)
                break;
        }
        System.out.println("Key Not Found!");
    }


    void display() {

        System.out.println();
        System.out.println("Hash table:");

        for (int i = 0; i < size; i++) {
            System.out.print(i + " ");
            if (keys[i] != null) {
                System.out.println("Key:" + keys[i] + "Value:" + values[i]);
            }
            else {
                System.out.println("empty");
            }
        }
    }
}
