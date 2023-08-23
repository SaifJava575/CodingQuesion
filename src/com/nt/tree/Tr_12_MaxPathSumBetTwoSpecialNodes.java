package com.nt.tree;

public class Tr_12_MaxPathSumBetTwoSpecialNodes {

	static int res = Integer.MIN_VALUE;

	// T(c)=O(N) and S(C)=O(Height of the Tree)
	public static int maxPathSum(Node root) {
		int h = maxPathSumUtil(root);
		if (root.left == null || root.right == null) 
			res = Math.max(res, h);
		
		return res;
	}

	static int maxPathSumUtil(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;

		int ls = maxPathSumUtil(root.left);
		int rs = maxPathSumUtil(root.right);

		if (root.left != null && root.right != null) {
			res = Math.max(res, (ls + rs + root.data));
			return Math.max(ls, rs) + root.data;
		}
		if (root.left == null)
			return rs + root.data;
		else
			return ls + root.data;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int response = maxPathSum(root);
		System.out.println("The max path sum is ::" + response);
	}

}
