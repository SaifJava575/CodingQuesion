package com.nt.hard;

public class Hd_28_ReOrderList {

	// T(c)=O(N) and S(C)=O(1)
	static void reorderlist(SingleLinkListNode head) {
		if (head == null || head.next == null) {
			return;
		}

		// Step 1: Find the middle of the linked list
		SingleLinkListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Step 2: Reverse the second half of the linked list
		SingleLinkListNode secondHalf = reverseLinkedList(slow.next);
		slow.next = null; // Break the original list into two halves

		// Step 3: Merge the first and reversed second halves alternately
		mergeLinkedLists(head, secondHalf);
	}

	private static SingleLinkListNode reverseLinkedList(SingleLinkListNode head) {
		SingleLinkListNode prev = null, current = head;
		while (current != null) {
			SingleLinkListNode temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}

	private static void mergeLinkedLists(SingleLinkListNode list1, SingleLinkListNode list2) {
		while (list2 != null) {
			SingleLinkListNode temp1 = list1.next, temp2 = list2.next;
			list1.next = list2;
			list2.next = temp1;
			list1 = temp1;
			list2 = temp2;
		}
	}

	private static void printLinkedList(SingleLinkListNode head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
		SingleLinkListNode head = new SingleLinkListNode(1);
		head.next = new SingleLinkListNode(2);
		head.next.next = new SingleLinkListNode(3);
		head.next.next.next = new SingleLinkListNode(4);
		head.next.next.next.next = new SingleLinkListNode(5);

		printLinkedList(head);
		reorderlist(head);
		printLinkedList(head);
	}

}
