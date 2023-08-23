package com.nt.tree;

public class Tr_10_SumTree {

	// T(C)=O(n) and S(C)=O(height of the Tree)
	static boolean isSumTree(Node root) {
		if (root == null)
			return true;
		return helper(root) > 0;
	}

	public static int helper(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;
		int leftSum = helper(root.left);
		int rightSum = helper(root.right);
		int sum = leftSum + rightSum;
		if (sum != root.data)
			return Integer.MIN_VALUE;
		return leftSum + rightSum + root.data;
	}

	public static void main(String[] args) {
		Node root = new Node(70);
		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(10);
		root.left.right = new Node(10);

		if (isSumTree(root))
			System.out.println("The Tree is sum of the left and Right Sub Tree");
		else
			System.out.println("The tree is not sum of the left and Right Sub Tree ");
	}

}
