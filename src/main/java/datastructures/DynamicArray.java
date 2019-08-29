package datastructures;

public class DynamicArray<String> {

    private Object[] data;
    private int size = 0;
    private int initialCapacity;

    public DynamicArray(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public String get(int index) {
        return (String) data[index];
    }

    public void set(int index, String value) {
        data[index] = value;
    }

    public void insert(int index, String value) {

        // Check size
        if (size() == initialCapacity) {
            resize();
        }

        //copy up
        for (int i = size(); i > index; i--) {
            data[i] = data[i - 1];
        }

        //insert element at index
        data[index] = value;
        size++;
    }

    public void delete(int index) {
        for (int i = index; i < size() - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean Contains(String value) {
        if (size() == 0) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (value.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    private void resize() {
        Object[] newData = new Object[initialCapacity * 2];
        for (int i = 0; i < initialCapacity; i++) {
            newData[i] = data[i];
        }
        data = newData;
        initialCapacity = initialCapacity * 2;
    }

    public int size() {
        return size;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println("data[i] = " + data[i]);
        }
    }

    public void add(String value) {

        if (size == initialCapacity) {
            resize();
        }

        data[size] = value;
        size++;
    }

}
