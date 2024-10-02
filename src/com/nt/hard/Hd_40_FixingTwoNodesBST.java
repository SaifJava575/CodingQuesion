package com.nt.hard;

import java.util.ArrayList;

public class Hd_40_FixingTwoNodesBST {

	// T(C)= O(n) and S(C)=O(1)
	public static Node correctBST(Node root) {
		ArrayList<Node> arr = new ArrayList<>();
		inorder(root, arr);
		Node a = null;
		Node b = null;
		int j = 0;
		for (int i = 0; i < arr.size() - 1; i++) {
			if (arr.get(i).data > arr.get(i + 1).data) {
				if (a == null) {
					a = arr.get(i);
					j = i;
					break;
				}
			}
		}

		b = arr.get(j + 1);
		for (int i = j + 2; i < arr.size(); i++) {
			if (b.data > arr.get(i).data) {
				b = arr.get(i);
			}
		}

		int temp = a.data;
		a.data = b.data;
		b.data = temp;

		return root;
	}

	static void inorder(Node root, ArrayList<Node> arr) {
		if (root == null) {
			return;
		}
		inorder(root.left, arr);
		arr.add(root);
		inorder(root.right, arr);
	}

	public static void printNode(Node root) {
		if (root == null) {
			return;
		}
		printNode(root.left);
		System.out.print(root.data + " ");
		printNode(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(8);
		root.right.left = new Node(3);
		root.right.right = new Node(7);
		root.left.left = new Node(2);
		root.left.right = new Node(20);
		System.out.println("Print The BST Tree");
		printNode(root);
		Node response = correctBST(root);
		System.out.println();
		System.out.println("After Correct the BST Tree");
		printNode(response);

	}

}
