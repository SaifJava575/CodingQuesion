package com.nt.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Hd_32_BurningTree {

	// T(C)=O(N) and S(c)=O(Hieght of the tree )
	public static int minTime(Node root, int target) {
		if (root == null)
			return 0;
		Node inf = new Node(2);
		Queue<Node> q = new LinkedList();
		q.add(root);
		HashMap<Node, Node> parentMap = new HashMap<>();
		while (!q.isEmpty()) {
			int lev = q.size();
			for (int i = 0; i < lev; i++) {
				Node temp = q.remove();

				if (temp.data == target)
					inf = temp;

				if (temp.left != null) {
					parentMap.put(temp.left, temp);
					q.add(temp.left);
				}
				if (temp.right != null) {
					parentMap.put(temp.right, temp);
					q.add(temp.right);
				}
			}
		}

		HashSet<Node> visited = new HashSet<>();
		Queue<Node> infection = new LinkedList<>();
		infection.add(inf);
		int totalTime = -1;
		while (!infection.isEmpty()) {
			int infected = infection.size();

			for (int i = 0; i < infected; i++) {
				Node temp = infection.remove();
				visited.add(temp);

				if (temp.left != null && !visited.contains(temp.left)) {
					infection.add(temp.left);
					visited.add(temp.left);

				}
				if (temp.right != null && !visited.contains(temp.right)) {
					infection.add(temp.right);
					visited.add(temp.left);
				}
				if (parentMap.containsKey(temp) && !visited.contains(parentMap.get(temp))) {

					Node parent = parentMap.get(temp);
					infection.add(parent);
					visited.add(parent);
				}
			}
			totalTime++;
		}

		return totalTime;

	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(6);
		root.right.right.right = new Node(9);
		root.right.right.right.right = new Node(10);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(8);

		int target = 8;
		int response = minTime(root, target);
		System.out.println("Min time required to complete burning tree " + response);

	}

}
