package com.nt.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Tr_03_RightViewOfTheTree {

	// T(c)=O(N). and S(C)=O(n)
	public static ArrayList<Integer> rightView(Node root) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		if (root == null)
			return ans;
		q.add(root);
		ans.add(root.data);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				if (q.peek().left != null)
					q.add(q.peek().left);
				if (q.peek().right != null)
					q.add(q.peek().right);
				if (i == 1)
					ans.add(q.poll().data);
				else
					q.poll();
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(50);
		root.left.right = new Node(60);

		root.left.right.left = new Node(70);
		root.left.right.right = new Node(80);

		ArrayList<Integer> response = rightView(root);
		System.out.println("The Right view of the Tree is:" + response);

	}

}
