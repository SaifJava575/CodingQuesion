package com.nt.hard;

public class Hd_61_DistributedCandies {

	static int minMoves(Node root, int[] mov) {
		if (root == null)
			return 0;
		int m = minMoves(root.left, mov) + minMoves(root.right, mov) + root.data - 1;

		mov[0] += Math.abs(m);

		return m;
	}

	public static int distributeCandy(Node root) {
		if (root == null)
			return 0;
		int[] mov = new int[1];
		mov[0] = 0;
		int m = minMoves(root, mov);

		return mov[0] + m;

	}

	public static void main(String[] args) {
		Node root = new Node(3);
		root.left = new Node(0);
		root.right = new Node(0);
		int response = distributeCandy(root);
		System.out.println("The number of candy distribute is ::" + response);
	}

}
