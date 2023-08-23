package com.nt.tree;

import java.util.ArrayList;

public class Tr_16_MirrorTree {

	//T(C)=O(n) and S(c)=O(Height of The Tree)
	static ArrayList<Integer> mirrorTree(Node root) {
		ArrayList<Integer> arr = new ArrayList<>();
		mirror(root, arr);
		return arr;
	}

	static void mirror(Node node, ArrayList<Integer> arr) {
		if (node == null)
			return;
		mirror(node.right, arr);
		arr.add(node.data);
		mirror(node.left, arr);
	}

	static void mirror1(Node node) {
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		if (node.left != null)
			mirror1(node.left);
		if (node.right != null)
			mirror1(node.right);

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);
		ArrayList<Integer> response = mirrorTree(root);
		System.out.println("The mirror Tree node is " + response);
	}

}
