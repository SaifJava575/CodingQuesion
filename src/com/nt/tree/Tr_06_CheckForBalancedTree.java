package com.nt.tree;

public class Tr_06_CheckForBalancedTree {

	// T(C)=O(N) and S(c)=O(H) Hieght of the Binary Tree
	static boolean isBalanced(Node root) {
		if (root == null)
			return true;
		int lh = hieghtOfTheTree(root.left);
		int rh = hieghtOfTheTree(root.right);
		if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;

		return false;
	}

	public static int hieghtOfTheTree(Node node) {
		if (node == null)
			return 0;
		return 1 + Math.max(hieghtOfTheTree(node.left), hieghtOfTheTree(node.right));
	}

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(60);
		
		//root.left.left.left = new Node(70);


		if (isBalanced(root))
			System.out.println("The tree is Balanced Tree");
		else
			System.out.println("The tree is not balanced Tree");

	}

}
