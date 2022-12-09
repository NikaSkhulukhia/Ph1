package mylinkedlist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLinkedList<T> {
    private static final Logger LOGGER = LogManager.getLogger();
    Node<T> head; // Head of the Node
    private int len; //Store length of the linked list

    // Constructor
    MyLinkedList() {
        this.head = null;
    }

    // Method addNode(T data): This method add a new element at the end
    void addNode(T data) {
        Node<T> temp = new Node<>(data); // creating a new generic Node
        // check if list is empty
        if (this.head == null) {
            head = temp;
        }
        // if list exists
        else {
            Node<T> X = head;
            // Iterate the List
            while (X.next != null) {
                X = X.next;
            }
            X.next = temp;
        }

        len++; // Increase the len after adding new Node
    }

    // Method addNode(int pos,T data): It will add a new element at a particular position
    void addNode(int pos, T data) {
        // Check position if It's valid or not
        if (pos > len + 1) {
            LOGGER.error("Position not found");
            return;
        }
        // if new Node is to be added in the beginning
        if (pos == 1) {
            Node<T> temp = head;
            head = new Node<T>(data);
            head.next = temp;
            return;
        }
        // Temporary Node to store previous head
        Node<T> temp = head;
        Node<T> prev = new Node<T>(null);
        // Iterating
        while (pos - 1 > 0) {
            prev = temp;
            temp = temp.next;
            pos--;
        }
        prev.next = new Node<T>(data);
        prev.next.next = temp;
    }
    // Method removeNode(T key): It will remove a Node from the LinkedList
    void removeNode(T key) {
        Node<T> prev = new Node<>(null);
        prev.next = head;
        Node<T> next = head.next;
        Node<T> temp = head;
        // This will check whether the value is present or not
        boolean exists = false;
        if (head.data == key) {
            head = head.next;
            // Node is present which we will want to remove
            exists = true;
        }
        while (temp.next != null) {
            // Convert the value to be compared to string
            if (String.valueOf(temp.data).equals(String.valueOf(key))) {
                prev.next = next;
                exists = true;
                break;
            }
            prev = temp;
            temp = temp.next;
            next = temp.next;
        }
        if (!exists && String.valueOf(temp.data).equals(String.valueOf(key))) {
            prev.next = null;
            exists = true;
        }
        // When the Node which we want to delete exists
        if (exists) {
            // reduce the len of linked list
            len--;
        }
        // If it does not exist
        else {
            LOGGER.error("Not found in linked list");
        }
    }
    public String toString() {
        String S = "{";
        Node<T> X = head;
        if (X == null)
            return S + "}";
        while (X.next != null) {
            S += X.data + "->";
            X = X.next;
        }
        S += String.valueOf(X.data);
        return S + "}";
    }
}
