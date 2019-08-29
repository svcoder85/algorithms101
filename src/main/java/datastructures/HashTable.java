package datastructures;

public class HashTable {

    private int INITIAL_SIZE = 16;
    private HashEntry[] data; // LinkedList

    /**
     * Class that represents a key-value pair inside a HashTable
     */
    class HashEntry {
        String key;
        String value;
        HashEntry next;

        HashEntry(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    HashTable() {
        data = new HashEntry[INITIAL_SIZE];
    }

    /**
     * @param key
     * @param value
     */
    public void put(String key, String value) {
        int index = getIndex(key);

        //create the new entry to be stored
        HashEntry current = data[index];
        if (current == null) {
            System.out.println("Key -> [" + key + "] not found. Hence adding it");
            current = new HashEntry(key, value);
            data[index] = current;
        } else {
            while (current.next != null) {
                //found key, update value
                if (current.key.equals(key)) {
                    System.out.println("Key -> [" + key + "] already exists! Hence updating value");
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            //append to the end of the linked list since we didn't find the desired key
            System.out.println("Key -> [" + key + "] not found. Hence adding it");
            current.next = new HashEntry(key, value);
        }
    }

    /**
     * @param key
     * @return
     */
    public String get(String key) {
        int index = getIndex(key);

        if (index < 0) {
            return null;
        }

        HashEntry current = data[index];
        while (current != null) {
            if (current.key.equals(key)) {
                System.out.println("Found value for key => [" + key + "] => " + current.value);
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    /**
     * @param key
     * @return
     */
    private int getIndex(String key) {
        int index = Math.abs(key.hashCode()) % INITIAL_SIZE;

        if (key.equals("John Smith") || key.equals("Sandra Dee")) {
            index = 2; //force a collision
        }
        System.out.println("Resolved key => [" + key + "] to index => [" + index + "]");
        return index;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (data.length == 0) {
            return null;
        }

        sb.append("HashTable:[");
        sb.append(System.getProperty("line.separator"));
        for (HashEntry hashEntry : data) {
            HashEntry current = hashEntry;
            while (current != null) {
                sb.append("[key: " + current.key + ", Value: " + current.value + "]");
                sb.append(System.getProperty("line.separator"));
                current = current.next;
            }
        }
        sb.append("]");

        return sb.toString();
    }
}