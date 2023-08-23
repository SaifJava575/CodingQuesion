package com.nt.tree;

import java.util.ArrayList;

public class Tr_01_CheckForBST {

	//T(c)=O(n)  and S(C)= O(Height of the BST).
	public static boolean isBST(Node root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean checkBST(Node root, int min, int max) {
		if (root == null)
			return true;
		if (root.data < min || root.data > max)
			return false;
		boolean left = checkBST(root.left, min, root.data);
		boolean right = checkBST(root.right, root.data, max);
		return left && right;
	}

	public static boolean isBST1(Node root) {

		ArrayList<Integer> arr = new ArrayList<>();
		DFS(root, arr);
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i - 1) >= arr.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	public static void DFS(Node root,ArrayList<Integer> arr) {
		if(root==null)
			return ;
		DFS(root.left,arr);
		arr.add(root.data);
		DFS(root.right,arr);
	}

	public static void main(String[] args) {
		Node root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);

		if (isBST1(root))
			System.out.println("This is BST ");
		else
			System.out.println("This is not BST");
	}

}
