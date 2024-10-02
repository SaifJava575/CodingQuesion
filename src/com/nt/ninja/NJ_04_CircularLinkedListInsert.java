package com.nt.ninja;
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

public class NJ_04_CircularLinkedListInsert {

    // Function to insert a node with 'val' at position 'k'
    static Node insert(int k, int val, Node<Integer> head) {
        // Create the new node to be inserted
        Node<Integer> newNode = new Node<>(val);
        
        // Case 1: Insert at the head (k == 0)
        if (k == 0) {
            if (head == null) {
                // If the list is empty, new node points to itself
                newNode.next = newNode;
                return newNode;
            } else {
                // If the list is not empty, we need to insert before the current head.
                Node<Integer> tail = head;
                // Find the tail node
                while (tail.next != head) {
                    tail = tail.next;
                }
                // Insert new node between tail and head
                newNode.next = head;
                tail.next = newNode;
                return newNode; // New node becomes the new head
            }
        }
        
        // Case 2: Insert at position 'k'
        Node<Integer> current = head;
        // Traverse the list to find the (k-1)th node
        for (int i = 0; i < k - 1; i++) {
            current = current.next;
        }
        // Insert newNode between current and current.next
        newNode.next = current.next;
        current.next = newNode;
        
        return head; // Head remains the same
    }

    // Helper function to print the circular linked list
    public static void printCircularList(Node<Integer> head) {
        if (head == null) return;
        
        Node<Integer> current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    @SuppressWarnings("unchecked")
	public static void main(String[] args) {
        // Test Case 1: Insert into a circular list
        Node<Integer> head = new Node<>(1);
        Node<Integer> second = new Node<>(2);
        Node<Integer> third = new Node<>(3);
        Node<Integer> fourth = new Node<>(4);
        
        // Creating the circular linked list: 1 -> 2 -> 3 -> 4 -> 1
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = head;
        
        // Insert 5 at position 1
        head = insert(1, 5, head);
        printCircularList(head); // Expected output: 1 5 2 3 4

        // Test Case 2: Insert at position 0 (new head)
        head = insert(0, 5, head);
        printCircularList(head); // Expected output: 5 1 5 2 3 4
    }
}
