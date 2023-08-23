package com.nt.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Tr_14_VerticalOrderTraversalBinaryTree {

	// T(c)=O(N) and S(C)=O(n)
	static ArrayList<Integer> verticalOrder(Node root) {
		Queue<Pair> q = new LinkedList<>();
		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		ArrayList<Integer> list = new ArrayList<>();
		q.add(new Pair(root, 0));
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			if (map.containsKey(curr.level)) {
				ArrayList<Integer> arr = map.get(curr.level);
				arr.add(curr.node.data);
				map.put(curr.level, arr);
			} else {
				ArrayList<Integer> arr = new ArrayList<>();
				arr.add(curr.node.data);
				map.put(curr.level, arr);
			}
			if (curr.node.left != null)
				q.add(new Pair(curr.node.left, curr.level - 1));
			if (curr.node.right != null)
				q.add(new Pair(curr.node.right, curr.level + 1));
		}
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			ArrayList<Integer> arr = entry.getValue();
			for (Integer val : arr)
				list.add(val);
		}
		return list;
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
		
		ArrayList<Integer> response=verticalOrder(root);
		System.out.println("The Vertical Order Binary Traversal Tree is ::"+response);

	}

}
