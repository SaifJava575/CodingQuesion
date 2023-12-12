package com.nt.hard;

public class Hd_06_BinaryToDoubleLinkedList {

	// T(c)=O(N) and S(C)=O(H)

	Node head, prev = null;

	Node bToDLL(Node root) {
		inorder(root);
		return head;
	}

	void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		if (head == null) {
			head = root;
		} else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		inorder(root.right);
	}

	Node bToDLL1(Node root) {
		if (root == null)
			return null;

		bToDLL(root.right);

		root.right = head;

		if (head != null)
			head.left = root;

		head = root;

		bToDLL(root.left);

		return head;
	}

	void printDoublyLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.right;
		}
	}

	public static void main(String[] args) {
		Hd_06_BinaryToDoubleLinkedList res = new Hd_06_BinaryToDoubleLinkedList();
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(30);
		System.out.println("The Binary tree to Double Linked List Tree Node is ::");
		Node response = res.bToDLL(root);
		res.printDoublyLinkedList(response);

	}

}
