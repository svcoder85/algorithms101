package datastructures;

public class LinkedList {

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public Node head;

    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int getFirst() {
        return head == null ? -1 : head.data;
    }

    public int getLast() {

        if (head == null) {
            return -1;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }

    public void addBack(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public int size() {

        if (head == null) {
            return 0;
        }

        int count = 1;
        Node current = head;

        while (current.next != null) {
            current = current.next;
            count++;
        }

        return count;
    }

    public void clear() {
        head = null;
    }

    public void deleteValue(int data) {

        //no elements
        if (head == null) {
            return;
        }

        //data matches head
        if (head.data == data) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
        System.out.println("");
    }

    public void removeFront() {
        if (head == null) {
            return;
        }

        head = head.next;
    }

    public void removeBack() {
        if (head == null) {
            return;
        }

        Node prev = null;
        Node current = head;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }

        prev.next = null;
    }

    public boolean contains(int data) {
        if (head == null) {
            return false;
        }

        Node current = head;
        while (current != null) {
            if(current.data == data){
                return true;
            }
            current = current.next;
        }
        return false;
    }

}
