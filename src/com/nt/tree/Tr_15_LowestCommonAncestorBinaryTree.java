package com.nt.tree;

public class Tr_15_LowestCommonAncestorBinaryTree {

	// T(c)=O(n) and S(C)=O(Height of the Tree)
	public static Node lca(Node root, int n1, int n2) {
		if (root == null || root.data == n1 || root.data == n2)
			return root;

		Node left_Lca = lca(root.left, n1, n2);
		Node right_Lca = lca(root.right, n1, n2);

		if (left_Lca == null)
			return right_Lca;
		if (right_Lca == null)
			return left_Lca;
		return root;
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
		
		Node ancestor=lca(root, 8, 9);
		System.out.println("The Lowest Common Ancestor is::"+ancestor.data);
	}

}
