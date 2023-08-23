package com.nt.tree;

import java.util.ArrayList;

public class Tr_19_PostOrderTraversalTree {

	// T(C)=O(n) and S(C)=O(Height of the tree)
	static ArrayList<Integer> postOrder(Node root) {
		ArrayList<Integer> arr = new ArrayList<>();
		helper(root, arr);
		return arr;
	}

	static void helper(Node node, ArrayList<Integer> arr) {
		if (node == null)
			return;
		helper(node.left, arr);
		helper(node.right, arr);
		arr.add(node.data);
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
		ArrayList<Integer> response = postOrder(root);
		System.out.println("The mirror Tree node is " + response);


	}

}
