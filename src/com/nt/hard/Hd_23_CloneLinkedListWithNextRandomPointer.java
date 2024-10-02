package com.nt.hard;

import java.util.HashMap;



public class Hd_23_CloneLinkedListWithNextRandomPointer {

	public NodeLinkedList copyList(NodeLinkedList head) {
		if (head == null) {
			return null;
		}

		HashMap<NodeLinkedList, NodeLinkedList> map = new HashMap<>();

		// First pass: create new nodes and map original nodes to new nodes.
		NodeLinkedList current = head;
		while (current != null) {
			map.put(current, new NodeLinkedList(current.data));
			current = current.next;
		}

		// Second pass: set next and random pointers for new nodes.
		current = head;
		while (current != null) {
			NodeLinkedList newNode = map.get(current);
			newNode.next = map.get(current.next);
			newNode.arb = map.get(current.arb);
			current = current.next;
		}

		// Return the head of the cloned list.
		return map.get(head);
	}

	private static void displayList(NodeLinkedList head) {
		NodeLinkedList current = head;
		while (current != null) {
			System.out.print("Data: " + current.data);
			if (current.next != null) {
				System.out.print(", Next: " + current.next.data);
			}
			if (current.arb != null) {
				System.out.print(", Arb: " + current.arb.data);
			}
			System.out.println();
			current = current.next;
		}
	}

	public static void main(String[] args) {
		NodeLinkedList head = new NodeLinkedList(1);
		NodeLinkedList node2 = new NodeLinkedList(2);
		NodeLinkedList node3 = new NodeLinkedList(3);

		head.next = node2;
		head.arb = node3;

		node2.next = node3;
		node2.arb = head;

		node3.next = null;
		node3.arb = node2;

		Hd_23_CloneLinkedListWithNextRandomPointer cloneInstance = new Hd_23_CloneLinkedListWithNextRandomPointer();
		NodeLinkedList clonedHead = cloneInstance.copyList(head);

		// Displaying the original and cloned linked lists.
		System.out.println("Original Linked List:");
		displayList(head);

		System.out.println("\nCloned Linked List:");
		displayList(clonedHead);

	}

}
