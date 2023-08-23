package com.nt.tree;

public class Tr_09_TwoTreeIdenticalDetermine {

	// T(C)=O(N). and S(c)=O(Height of the Tree)
	static boolean isIdentical(Node root1, Node root2) {
		if (root1 == null && root2 == null)
			return true;
		else if (root1 == null || root2 == null)
			return false;
		return ((root1.data == root2.data) && isIdentical(root1.left, root2.left)
				&& isIdentical(root1.right, root2.right));

	}

	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);

		root1.left.left = new Node(4);
		root1.left.right = new Node(5);

		root1.right.left = new Node(6);
		root1.right.right = new Node(7);

		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);

		root2.left.left = new Node(4);
		root2.left.right = new Node(5);

		root2.right.left = new Node(6);
		root2.right.right = new Node(7);

		if (isIdentical(root1, root2))
			System.out.println("Two Tree is Identical");
		else
			System.out.println("Two Tree is not Identical");

	}

}
