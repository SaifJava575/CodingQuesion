package com.nt.tree;

import java.util.ArrayList;

public class Tr_04_BoundaryTraversalTree {

	public static ArrayList<Integer> boundary(Node node) {
		ArrayList<Integer> arr = new ArrayList<>();
		if(node==null)
			return arr;
		 if(isLeafNode(node)==false)
			    arr.add(node.data);
		 
		leftBoundary(node, arr);
		leafNodes(node, arr);
		rightNode(node, arr);
		return arr;

	}

	private static boolean isLeafNode(Node root) {
		if (root.left == null && root.right == null)
			return true;
		return false;
	}

	private static void leftBoundary(Node root, ArrayList<Integer> arr) {
		Node curr = root.left;
		while (curr != null) {
			if (isLeafNode(curr))
				return;
			else
				arr.add(curr.data);
			if (curr.left != null)
				curr = curr.left;
			else
				curr = curr.right;
		}
	}

	private static void leafNodes(Node root, ArrayList<Integer> arr) {
		if (root == null)
			return;
		if (isLeafNode(root))
			arr.add(root.data);
		leafNodes(root.left, arr);
		leafNodes(root.right, arr);
	}

	private static void rightNode(Node root, ArrayList<Integer> arr) {
		Node curr = root.right;
		ArrayList<Integer> tmp = new ArrayList<>();
		while (curr != null) {
			if (isLeafNode(curr))
				break;
			else
				tmp.add(curr.data);
			if (curr.right != null)
				curr = curr.right;
			else
				curr = curr.left;
		}
		for (int i = tmp.size() - 1; i >= 0; i--)
			arr.add(tmp.get(i));
	}

	public static void main(String[] args) {
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.right.left = new Node(8);
		root.left.right.right = new Node(9);
		
		ArrayList<Integer> response=boundary(root);
		System.out.println("The boundary tree is::"+response);

	}

}
