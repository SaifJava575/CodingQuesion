package com.nt.tree;

public class Tr_08_HieghtOfTheBinaryTree {

	// T(c)=O(n) and S(C)=O(n)
	public static int height(Node node) {
		if (node == null)
			return 0;
		int lh = height(node.left);
		int rh = height(node.right);
		int hieght = 1 + Math.max(lh, rh);
		return hieght;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		int response = height(root);
		System.out.println("The hieght of the Binary Tree is ::" + response);

	}

}
