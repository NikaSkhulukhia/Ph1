package mylinkedlist;

public class Node<T> {
    T data; // Stores data of the node
    Node<T> next; // Store address of the node

    // Constructor
    Node(T data) {
        this.data = data;
        this.next = null;
    }
}
